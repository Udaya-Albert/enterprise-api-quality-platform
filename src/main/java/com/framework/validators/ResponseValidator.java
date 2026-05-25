package com.framework.validators;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseValidator {

    private ResponseValidator() {
    }

    public static void validateStatusCode(
            Response response,
            int expectedStatusCode) {

        assertThat(response.getStatusCode())

                .isEqualTo(expectedStatusCode);
    }
    
    public static void validateResponseTime(
            Response response,
            long expectedTime) {

        assertThat(response.time())

                .isLessThan(expectedTime);
    }
    
    public static void validateContentType(
            Response response,
            String expectedContentType) {

        assertThat(response.contentType())

                .contains(expectedContentType);
    }
}