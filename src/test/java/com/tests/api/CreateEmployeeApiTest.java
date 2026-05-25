package com.tests.api;

import com.framework.builders.EmployeeRequestBuilder;
import com.framework.clients.ApiClient;
import com.framework.constants.FrameworkConstants;
import com.framework.models.request.EmployeeRequest;
import com.framework.validators.ResponseValidator;
import com.tests.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateEmployeeApiTest extends BaseTest {

    @Test
    public void createEmployeeTest() {

        EmployeeRequest employeeRequest =
                EmployeeRequestBuilder.buildEmployee();

        Response response =
                ApiClient.post(
                        "/web/index.php/api/v2/pim/employees",
                        employeeRequest);

        ResponseValidator.validateStatusCode(
                response,
                FrameworkConstants.CREATED_STATUS_CODE);

        System.out.println(response.asPrettyString());
    }
}