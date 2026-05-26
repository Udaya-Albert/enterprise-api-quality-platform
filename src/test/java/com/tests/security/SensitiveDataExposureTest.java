package com.tests.security;

import com.framework.clients.ApiClient;
import com.framework.security.SecurityValidator;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SensitiveDataExposureTest
        extends BaseTest {

    @Test
    public void sensitiveDataExposureTest() {

        Response response =
                ApiClient.get("/");

        SecurityValidator
                .validateSensitiveDataExposure(
                        response);
    }
}