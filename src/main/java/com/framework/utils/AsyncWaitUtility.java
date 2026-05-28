package com.framework.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class AsyncWaitUtility {

    private AsyncWaitUtility() {
    }

    public static boolean waitUntil(

            Supplier<Boolean> condition,

            int timeoutSeconds) {

        Instant endTime =

                Instant.now()

                        .plus(Duration.ofSeconds(
                                timeoutSeconds));

        while (Instant.now().isBefore(endTime)) {

            if (condition.get()) {

                return true;
            }

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        return false;
    }
}