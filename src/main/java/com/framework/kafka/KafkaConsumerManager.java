package com.framework.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerManager {

    private static KafkaConsumer<String, String> consumer;

    private KafkaConsumerManager() {
    }

    static {

        Properties properties =
                new Properties();

        properties.put(
                "bootstrap.servers",
                "localhost:9092");

        properties.put(
                "group.id",
                "automation-group");

        properties.put(
                "key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        properties.put(
                "value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        properties.put(
                "auto.offset.reset",
                "earliest");

        consumer =
                new KafkaConsumer<>(properties);
    }

    public static String consumeMessage(
            String topic) {

        consumer.subscribe(
                Collections.singletonList(
                        topic));

        ConsumerRecords<String, String> records =

                consumer.poll(
                        Duration.ofSeconds(10));

        for (ConsumerRecord<String, String> record
                : records) {

            return record.value();
        }

        return null;
    }
}