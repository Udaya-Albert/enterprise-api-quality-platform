package com.framework.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class WireMockManager {

    private static WireMockServer wireMockServer;

    private WireMockManager() {
    }

    public static void startServer() {

        wireMockServer =
                new WireMockServer(
                        options().port(9090));

        wireMockServer.start();

        System.out.println(
                "WireMock Server Started");
    }

    public static void stopServer() {

        if (wireMockServer != null) {

            wireMockServer.stop();

            System.out.println(
                    "WireMock Server Stopped");
        }
    }

    public static WireMockServer getServer() {

        return wireMockServer;
    }
}