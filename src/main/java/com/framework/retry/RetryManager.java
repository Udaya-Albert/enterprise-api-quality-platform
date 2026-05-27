package com.framework.retry;

public class RetryManager {

    private RetryManager() {
    }

    public static void retryOperation(
            Runnable runnable,
            int retryCount) {

        int attempts = 0;

        while (attempts < retryCount) {

            try {

                runnable.run();

                return;

            } catch (Exception e) {

                attempts++;

                System.out.println(
                        "Retry Attempt : "
                                + attempts);
            }
        }

        throw new RuntimeException(
                "Retry attempts exhausted");
    }
}