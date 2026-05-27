package com.tests.wiremock;

import com.framework.validators.SchemaValidator;
import com.framework.wiremock.WireMockManager;
import com.tests.BaseWireMockTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ContractValidationTest
        extends BaseWireMockTest {

    @Test
    public void contractValidationTest() {

        WireMockManager.getServer()

                .stubFor(

                        get(urlEqualTo("/contract-api"))

                                .willReturn(

                                        aResponse()

                                                .withStatus(200)

                                                .withHeader(
                                                        "Content-Type",
                                                        "application/json")

                                                .withBody(
                                                        """
                                                        {
                                                          "data": []
                                                        }
                                                        """)));

        Response response =

                RestAssured

                        .given()

                        .baseUri("http://localhost:9090")

                        .when()

                        .get("/contract-api");

        SchemaValidator.validateSchema(
                response,
                "schemas/employee-schema.json");
    }
}