package com.framework.builders;

import com.framework.auth.AuthManager;
import com.framework.config.ConfigManager;
import com.framework.constants.FrameworkConstants;
import com.framework.filters.RequestLoggingFilter;
import com.framework.filters.ResponseLoggingFilter;
import com.framework.utils.CorrelationIdManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {

    private RequestSpecificationBuilder() {
    }

    public static RequestSpecification buildRequestSpec() {

        ConfigManager config =
                ConfigManager.getInstance();

        RequestSpecBuilder builder = new RequestSpecBuilder()

                .setBaseUri(
                        config.getProperty("base.url"))

                .setContentType(
                        FrameworkConstants.APPLICATION_JSON)

                .addHeader(
                        "X-Correlation-ID",
                        CorrelationIdManager
                                .generateCorrelationId())

                .addFilter(
                        new RequestLoggingFilter())

                .addFilter(
                        new ResponseLoggingFilter());
                
        	String token = AuthManager.getToken();
        	if (token != null && !token.isBlank()) {

        	    builder.addHeader(
        	            FrameworkConstants.AUTHORIZATION,
        	            "Bearer " + token);
        	}
        	return builder.build();
    }
}