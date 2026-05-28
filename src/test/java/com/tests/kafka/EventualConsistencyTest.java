package com.tests.kafka;

import com.framework.utils.AsyncWaitUtility;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventualConsistencyTest {

    private boolean eventProcessed = false;

    @Test
    public void eventualConsistencyTest() {

        new Thread(() -> {

            try {

                Thread.sleep(5000);

                eventProcessed = true;

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }

        }).start();

        boolean result =

                AsyncWaitUtility.waitUntil(

                        () -> eventProcessed,

                        10);

        assertThat(result)

                .isTrue();
    }
}