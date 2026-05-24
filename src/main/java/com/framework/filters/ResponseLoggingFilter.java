package com.framework.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseLoggingFilter implements Filter {

    private static final Logger logger =
            LoggerFactory.getLogger(ResponseLoggingFilter.class);

    @Override
    public Response filter(
            FilterableRequestSpecification requestSpec,
            FilterableResponseSpecification responseSpec,
            FilterContext ctx) {

        Response response =
                ctx.next(requestSpec, responseSpec);

        logger.info("RESPONSE STATUS : {}",
                response.getStatusCode());

        logger.info("RESPONSE BODY : {}",
                response.getBody().asPrettyString());

        return response;
    }
}