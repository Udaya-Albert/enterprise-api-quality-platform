package com.tests.performance;

import com.framework.clients.ApiClient;
import com.framework.performance.PerformanceValidator;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiPerformanceTest extends BaseTest {

    @Test
    public void apiPerformanceTest() {

        Response response =
                ApiClient.get("/");

        PerformanceValidator
                .validateResponseTime(
                        response,
                        5000);
    }
}