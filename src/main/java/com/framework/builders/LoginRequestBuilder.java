package com.framework.builders;

import com.framework.models.request.LoginRequest;
import com.framework.security.SecretManager;

public class LoginRequestBuilder {

    private LoginRequestBuilder() {
    }

    public static LoginRequest buildLoginRequest() {

        SecretManager secretManager =
                SecretManager.getInstance();

        return LoginRequest.builder()

                .username(
                        secretManager.getSecret(
                                "ORANGE_USERNAME"))

                .password(
                        secretManager.getSecret(
                                "ORANGE_PASSWORD"))

                .build();
    }
}