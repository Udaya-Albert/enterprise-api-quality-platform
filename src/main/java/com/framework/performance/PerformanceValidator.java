package com.framework.performance;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class PerformanceValidator {

    private PerformanceValidator() {
    }

    public static void validateResponseTime(
            Response response,
            long maxResponseTime) {

        assertThat(response.time())

                .isLessThan(maxResponseTime);
    }
}