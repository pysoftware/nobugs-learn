package ru.sazonov.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

abstract class RestApiClient<T> {
    private final RequestSpecification requestSpecification;
    private final String clientBasePath;

    public RestApiClient(RequestSpecification requestSpecification, String clientBasePath) {
        this.requestSpecification = requestSpecification;
        this.clientBasePath = clientBasePath;
    }

    public final Response post(String path, Object body) {
        return given()
                .spec(requestSpecification)
                .when()
                .body(body)
                .post(buildPath(path))
                .thenReturn();
    }

    public final Response get(String path, Object... params) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(buildPath(path), params)
                .thenReturn();
    }

    public T withBaseAuth(String token) {
        requestSpecification.header("Authorization", token);
        return  (T) this;
    }

    // TODO does this override default spec?
    public T withSpec(RequestSpecification requestSpecification) {
        requestSpecification.spec(requestSpecification);
        return  (T) this;
    }

    private String buildPath(String path) {
        return clientBasePath + path;
    }
}
