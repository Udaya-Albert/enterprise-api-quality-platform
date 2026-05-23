package com.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager instance;

    private final Properties properties;

    private ConfigManager() {

        properties = new Properties();

        String env =
                System.getProperty("env", "qa");

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "environments/" + env + ".properties");

            properties.load(fis);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load config file: " + env,
                    e);
        }
    }

    public static ConfigManager getInstance() {

        if (instance == null) {
            instance = new ConfigManager();
        }

        return instance;
    }

    public String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {

            throw new RuntimeException(
                    "Missing config key: " + key);
        }

        return value;
    }
}

