package com.framework.validators;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidator {

    private SchemaValidator() {
    }

    public static void validateSchema(
            Response response,
            String schemaPath) {

        response.then()

                .assertThat()

                .body(
                        JsonSchemaValidator.matchesJsonSchemaInClasspath(
                                schemaPath));
    }
}