package com.tests.api;

import com.framework.clients.ApiClient;
import com.framework.validators.ResponseValidator;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class NegativeEmployeeApiTest extends BaseTest {

    @Test
    public void invalidEndpointTest() {

        Response response =
                ApiClient.get("/invalid-endpoint");

        ResponseValidator.validateStatusCode(
                response,
                404);
    }
}