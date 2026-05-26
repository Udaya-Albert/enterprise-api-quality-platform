package com.tests.security;

import com.framework.clients.ApiClient;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FuzzTestingExample extends BaseTest {

    @Test
    public void fuzzTest() {

        String oversizedInput =
                "A".repeat(5000);

        Response response =
                ApiClient.get(
                        "/users?name="
                                + oversizedInput);

        System.out.println(
                response.getStatusCode());
    }
}