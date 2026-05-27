package com.tests.wiremock;

import com.framework.wiremock.WireMockManager;
import com.tests.BaseWireMockTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class FaultInjectionTest
        extends BaseWireMockTest {

    @Test
    public void faultInjectionTest() {

        WireMockManager.getServer()

                .stubFor(

                        get(urlEqualTo("/error-api"))

                                .willReturn(

                                        aResponse()

                                                .withStatus(500)

                                                .withBody(
                                                        "Internal Server Error")));

        Response response =

                RestAssured

                        .given()

                        .baseUri("http://localhost:9090")

                        .when()

                        .get("/error-api");

        System.out.println(
                response.getStatusCode());
    }
}