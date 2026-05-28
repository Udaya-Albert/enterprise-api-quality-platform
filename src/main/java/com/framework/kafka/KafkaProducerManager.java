package com.framework.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerManager {

    private static KafkaProducer<String, String> producer;

    private KafkaProducerManager() {
    }

    static {

        Properties properties =
                new Properties();

        properties.put(
                "bootstrap.servers",
                "localhost:9092");

        properties.put(
                "key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        properties.put(
                "value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        producer =
                new KafkaProducer<>(properties);
    }

    public static void publishMessage(
            String topic,
            String message) {

        producer.send(
                new ProducerRecord<>(
                        topic,
                        message));

        producer.flush();

        System.out.println(
                "Published Message : "
                        + message);
    }
}