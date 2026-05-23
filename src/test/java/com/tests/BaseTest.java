package com.tests;

import com.framework.config.ConfigManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected ConfigManager config;

    @BeforeSuite
    public void setupFramework() {

        config = ConfigManager.getInstance();

        System.out.println("Framework Initialized");
        System.out.println("Base URL : "
                + config.getProperty("base.url"));
    }
}
