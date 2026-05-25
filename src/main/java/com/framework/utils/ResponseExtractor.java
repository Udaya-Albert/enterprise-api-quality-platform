package com.framework.utils;

import io.restassured.response.Response;

public class ResponseExtractor {

    private ResponseExtractor() {
    }

    public static String extractValue(
            Response response,
            String jsonPath) {

        return response.jsonPath()
                .getString(jsonPath);
    }
}