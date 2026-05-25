package com.framework.utils;

import java.util.UUID;

public class TestDataGenerator {

    private TestDataGenerator() {
    }

    public static String randomEmployeeId() {

        return UUID.randomUUID()

                .toString()

                .substring(0, 6);
    }

    public static String randomEmail() {

        return "user"

                + System.currentTimeMillis()

                + "@mail.com";
    }
}