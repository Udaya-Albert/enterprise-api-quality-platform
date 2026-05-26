package com.tests.security;

import com.framework.clients.ApiClient;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SqlInjectionTest extends BaseTest {

    @Test
    public void sqlInjectionTest() {

        String maliciousPayload =
                "' OR '1'='1";

        Response response =
                ApiClient.get(
                        "/users?search="
                                + maliciousPayload);

        System.out.println(
                response.asPrettyString());
    }
}