package com.tests.api;

import com.framework.builders.EmployeeRequestBuilder;
import com.framework.clients.ApiClient;
import com.framework.models.request.EmployeeRequest;
import com.framework.utils.ResponseExtractor;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class EmployeeApiChainingTest extends BaseTest {

    @Test
    public void employeeApiFlowTest() {

        EmployeeRequest request =
                EmployeeRequestBuilder.buildEmployee();

        Response createResponse =
                ApiClient.post(
                        "/api/v1/employees",
                        request);

        String employeeId =
                ResponseExtractor.extractValue(
                        createResponse,
                        "data.id");

        System.out.println(
                "Extracted Employee ID : "
                        + employeeId);
    }
}