package com.framework.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLoggingFilter implements Filter {

    private static final Logger logger =
            LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public Response filter(
            FilterableRequestSpecification requestSpec,
            FilterableResponseSpecification responseSpec,
            FilterContext ctx) {

        logger.info("REQUEST METHOD : {}",
                requestSpec.getMethod());

        logger.info("REQUEST URI : {}",
                requestSpec.getURI());

        logger.info("REQUEST HEADERS : {}",
                requestSpec.getHeaders());
        
        Object requestBody = requestSpec.getBody();
        logger.info("REQUEST BODY : {}",
        		requestBody != null ? requestBody : "EMPTY");

        return ctx.next(requestSpec, responseSpec);
    }
}