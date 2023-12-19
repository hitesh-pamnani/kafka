package com.example.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.confluent.developer.avro.Hobbit;

@Component
public class Consumer {

    /*@KafkaListener(topics = "hobbit", groupId = "spring-consumer")
    public void consumer(ConsumerRecord<Integer, String> record){
        System.out.println("Received: Key: "+record.key()+" Value: "+record.value());
    }*/

    /*@KafkaListener(topics = "streams-wordcount-output", groupId = "word-count-consumer")
    public void wordCountConsumer(ConsumerRecord<String, Long> record) {
        System.out.println("Word Count Received: Key: "+record.key()+" Value: "+record.value());
    }*/

    @KafkaListener(topics = "hobbit-avro", groupId = "spring-consumer")
    public void consumer(ConsumerRecord<Integer, Hobbit> record){
        System.out.println("Received: Key: "+record.key()+" Value: "+record.value());
    }
}
