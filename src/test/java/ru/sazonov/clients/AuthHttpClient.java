package ru.sazonov.clients;

import io.restassured.specification.RequestSpecification;
import ru.sazonov.requests.UserLoginRequest;
import ru.sazonov.responses.UserLoginResponse;

public class AuthHttpClient extends RestApiClient {
    private final static String BASE_PATH = "/auth";
    private final static String LOGIN_PATH = "/login";

    AuthHttpClient(RequestSpecification requestSpecification) {
        super(requestSpecification, BASE_PATH);
    }

    public RestResponse<UserLoginResponse> login(UserLoginRequest request) {
        return new RestResponse<>(post(LOGIN_PATH, request), UserLoginResponse.class);
    }

    public RestResponse<UserLoginResponse> loginAsAdmin() {
        return new RestResponse<>(
                post(
                        LOGIN_PATH,
                        new UserLoginRequest(
                                System.getProperty("admin.username"),
                                System.getProperty("admin.password")
                        )
                ),
                UserLoginResponse.class
        );
    }
}
