package com.example.spring.kafka.producer;

import java.time.Duration;
import java.util.function.Function;
import java.util.stream.Stream;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RequiredArgsConstructor
@Component
public class Producer {
    private final KafkaTemplate<Integer, String> template;

    Faker faker;

    @EventListener(ApplicationStartedEvent.class)
    public void generate(){
        faker = new Faker();
        final Flux<Long> interval = Flux.interval(Duration.ofMillis(1_000));
        Flux<String> quotes = Flux.fromStream(Stream.generate(() -> faker.hobbit().quote()));
        Flux.zip(interval, quotes).map(
                (Function<Tuple2<Long, String>, Object>) tuple -> template.send("hobbit-avro", faker.random().nextInt(10000), tuple.getT2())).blockLast();
    }
}
