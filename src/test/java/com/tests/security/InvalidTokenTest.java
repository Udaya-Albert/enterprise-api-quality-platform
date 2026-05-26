package com.tests.security;

import com.framework.auth.AuthManager;
import com.framework.clients.ApiClient;
import com.framework.validators.ResponseValidator;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class InvalidTokenTest extends BaseTest {

    @Test
    public void invalidTokenTest() {

        AuthManager.setToken(
                "invalid-token");

        Response response =
                ApiClient.get(
                        "/web/index.php/api/v2/pim/employees");

        ResponseValidator.validateStatusCode(
                response,
                401);
    }
}