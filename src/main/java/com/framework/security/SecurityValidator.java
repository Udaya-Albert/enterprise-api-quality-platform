package com.framework.security;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class SecurityValidator {

    private SecurityValidator() {
    }

    public static void validateSecurityHeaders(
            Response response) {

        assertThat(
                response.getHeader("X-Frame-Options"))

                .isNotNull();

        assertThat(
                response.getHeader(
                        "X-Content-Type-Options"))

                .isNotNull();
    }

    public static void validateSensitiveDataExposure(
            Response response) {

        String responseBody =
                response.asPrettyString();

        assertThat(responseBody)

                .doesNotContain("password")

                .doesNotContain("secret")

                .doesNotContain("token");
    }
}