package com.tests.wiremock;

import com.framework.wiremock.WireMockManager;
import com.tests.BaseWireMockTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockEmployeeApiTest
        extends BaseWireMockTest {

    @Test
    public void mockEmployeeApiTest() {

        WireMockManager.getServer()

                .stubFor(

                        get(urlEqualTo("/employees"))

                                .willReturn(

                                        aResponse()

                                                .withStatus(200)

                                                .withHeader(
                                                        "Content-Type",
                                                        "application/json")

                                                .withBody(
                                                        """
                                                        {
                                                          "employees": [
                                                            {
                                                              "id": 101,
                                                              "name": "John Architect"
                                                            }
                                                          ]
                                                        }
                                                        """)));

        Response response =

                RestAssured

                        .given()

                        .baseUri("http://localhost:9090")

                        .when()

                        .get("/employees");

        System.out.println(
                response.asPrettyString());
    }
}