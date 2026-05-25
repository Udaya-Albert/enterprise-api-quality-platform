package com.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {

    private static final ObjectMapper objectMapper =
            new ObjectMapper();

    private JacksonUtils() {
    }

    public static String convertObjectToJson(
            Object object) {

        try {

            return objectMapper
                    .writeValueAsString(object);

        } catch (Exception e) {

            throw new RuntimeException(
                    "JSON serialization failed",
                    e);
        }
    }
}