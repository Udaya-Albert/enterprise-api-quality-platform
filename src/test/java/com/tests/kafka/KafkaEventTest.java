package com.tests.kafka;

import com.framework.kafka.KafkaConsumerManager;
import com.framework.kafka.KafkaProducerManager;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KafkaEventTest {

    @Test
    public void kafkaEventTest() {

        String topic =
                "employee-events";

        String message =
                "Employee Created";

        KafkaProducerManager.publishMessage(
                topic,
                message);

        String consumedMessage =

                KafkaConsumerManager.consumeMessage(
                        topic);

        assertThat(consumedMessage)

                .isEqualTo(message);
    }
}