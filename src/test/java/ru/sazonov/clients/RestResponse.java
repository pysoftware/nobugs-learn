package ru.sazonov.clients;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import ru.sazonov.assertions.ResponseAssertion;

public class RestResponse<T> extends RestAssuredResponseImpl {
    private final Response response;
    private final Class<T> responseClazz;

    public RestResponse(Response response, Class<T> responseClazz) {
        this.response = response;
        this.responseClazz = responseClazz;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public T extractBody() {
        return response.getBody().as(responseClazz);
    }

    public String extractHeader(String name) {
        return response.getHeader(name);
    }

    public String extractBaseAuthHeader() {
        return response.getHeader("Authorization");
    }

    public ResponseAssertion<T> assertResponse() {
        return ResponseAssertion.assertResponse(this);
    }
}
