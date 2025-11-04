package ru.sazonov.clients;

import io.restassured.specification.RequestSpecification;
import ru.sazonov.requests.CreateUserRequest;
import ru.sazonov.responses.CreateUserResponse;

public final class AdminApiClient extends RestApiClient<AdminApiClient> {
    private final static String BASE_PATH = "/admin";
    private final static String GET_ALL_USERS_ENDPOINT = "/users";
    private final static String CREATE_NEW_USER_ENDPOINT = "/users";

    AdminApiClient(RequestSpecification requestSpecification) {
        super(requestSpecification, BASE_PATH);
    }

    public RestResponse<CreateUserResponse> createUser(CreateUserRequest request) {
        return new RestResponse<>(post(CREATE_NEW_USER_ENDPOINT, request), CreateUserResponse.class);
    }
}
