package ru.sazonov;

import java.util.List;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class ApiSpecifications {
    public static int PORT;

    private static RequestSpecBuilder defaultSpec() {
        return new RequestSpecBuilder()
                .setConfig(
                        RestAssured.config()
                                .logConfig(
                                        LogConfig.logConfig()
                                                .enablePrettyPrinting(true)
                                )
                )
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(System.getProperty("server.host") + System.getProperty("server.api.basePath") + System.getProperty("server.api.version"))
                .setPort(PORT)
                .addFilters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()));
    }

    /**
     *
     * @param token отправляем авторизационный хедер
     */
    public static RequestSpecification withAuth(String token) {
        return defaultSpec()
                .addHeader("Authorization", token)
                .build();
    }

    /**
     * Не отправляем авторизационный хедер
     */
    public static RequestSpecification noAuth() {
        return defaultSpec()
                .build();
    }

    public static RequestSpecification base() {
        return defaultSpec()
                .build();
    }
}
