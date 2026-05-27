package com.tests;

import com.framework.wiremock.WireMockManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseWireMockTest {

    @BeforeSuite
    public void setupWireMock() {

        WireMockManager.startServer();
    }

    @AfterSuite
    public void tearDownWireMock() {

        WireMockManager.stopServer();
    }
}