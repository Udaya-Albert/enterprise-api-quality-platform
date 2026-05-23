package com.framework.security;

import io.github.cdimascio.dotenv.Dotenv;

public class SecretManager {

    private static SecretManager instance;

    private final Dotenv dotenv;

    private SecretManager() {

        dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();
    }

    public static SecretManager getInstance() {

        if (instance == null) {
            instance = new SecretManager();
        }

        return instance;
    }

    public String getSecret(String key) {

        String value = dotenv.get(key);

        if (value == null || value.isBlank()) {

            value = System.getenv(key);
        }

        if (value == null || value.isBlank()) {

            throw new RuntimeException(
                    "Missing secret for key: " + key);
        }

        return value;
    }
}