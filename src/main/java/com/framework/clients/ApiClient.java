package com.framework.clients;

import com.framework.builders.RequestSpecificationBuilder;
import com.framework.builders.ResponseSpecificationBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    private ApiClient() {
    }

    public static Response get(String endpoint) {

        return RestAssured
                .given()

                .spec(RequestSpecificationBuilder
                        .buildRequestSpec())

                .when()

                .get(endpoint)

                .then()

                .spec(ResponseSpecificationBuilder
                        .buildResponseSpec())

                .extract()

                .response();
    }
}