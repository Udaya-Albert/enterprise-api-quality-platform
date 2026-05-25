package com.framework.auth;

public class AuthManager {

    private static String token;

    private AuthManager() {
    }

    public static void setToken(String authToken) {
        token = authToken;
    }

    public static String getToken() {
        return token;
    }
}