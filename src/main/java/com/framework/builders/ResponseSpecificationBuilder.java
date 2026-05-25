package com.framework.builders;

import com.framework.constants.FrameworkConstants;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationBuilder {

    private ResponseSpecificationBuilder() {
    }

    public static ResponseSpecification buildResponseSpec() {

        return new ResponseSpecBuilder()

             //   .expectContentType(
             //           FrameworkConstants.APPLICATION_JSON)

                .build();
    }
}