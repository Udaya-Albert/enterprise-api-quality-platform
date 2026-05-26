package com.tests.security;

import com.framework.clients.ApiClient;
import com.framework.validators.ResponseValidator;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UnauthorizedAccessTest extends BaseTest {

    @Test
    public void unauthorizedAccessTest() {

        Response response =
                ApiClient.get(
                        "/web/index.php/api/v2/pim/employees");

        ResponseValidator.validateStatusCode(
                response,
                401);
    }
}