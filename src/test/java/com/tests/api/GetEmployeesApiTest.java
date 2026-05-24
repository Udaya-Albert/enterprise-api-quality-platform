package com.tests.api;

import com.framework.clients.ApiClient;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetEmployeesApiTest extends BaseTest {

    @Test
    public void getEmployeesTest() {

        Response response =
                ApiClient.get("/web/index.php/api/v2/pim/employees");

        System.out.println(response.asPrettyString());
    }
}