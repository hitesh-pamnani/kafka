package com.example.spring.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class SpringKafkaConfig {

    @Bean
    NewTopic hobbit2(){
        return TopicBuilder.name("hobbit2").partitions(24).replicas(3).build();
    }

    @Bean
    NewTopic wordCount(){
        return TopicBuilder.name("streams-wordcount-output").partitions(6).replicas(3).build();
    }

    @Bean
    NewTopic hobbitAvro(){
        return TopicBuilder.name("hobbit-avro").partitions(24).replicas(3).build();
    }
}
