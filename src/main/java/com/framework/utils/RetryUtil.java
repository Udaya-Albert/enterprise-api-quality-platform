package com.framework.utils;

import java.time.Duration;
import java.util.function.Supplier;

import static org.awaitility.Awaitility.await;

public class RetryUtil {

    private RetryUtil() {
    }

    public static void waitUntil(
            Supplier<Boolean> condition,
            long timeoutSeconds,
            long pollIntervalSeconds) {

        await()

                .atMost(Duration.ofSeconds(timeoutSeconds))

                .pollInterval(Duration.ofSeconds(pollIntervalSeconds))

                .until(condition::get);
    }
}