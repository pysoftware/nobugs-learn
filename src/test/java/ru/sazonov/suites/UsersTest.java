package ru.sazonov.suites;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.sazonov.AbstractIntegrationTest;
import ru.sazonov.UserUtils;
import ru.sazonov.requests.CreateUserRequest;

import static ru.sazonov.UserRoles.USER;
import static ru.sazonov.clients.HttpClientFactory.createAdminClient;
import static ru.sazonov.clients.HttpClientFactory.createAuthClient;

public class UsersTest extends AbstractIntegrationTest {
    @Test
    public void adminCanCreateNewUserWithValidData() {
        String authHeader = createAuthClient().loginAsAdmin().extractBaseAuthHeader();
        CreateUserRequest user = CreateUserRequest.generateValidUserData(USER);
        createAdminClient()
                .withBaseAuth(authHeader)
                .createUser(user)
                .assertResponse()
                .isCreated()
                .assertBody((model, softAssert) -> {
                    softAssert.assertThat(user.getUsername()).isEqualTo(model.getUsername());
                    softAssert.assertThat(user.getPassword()).isNotNull();
                    softAssert.assertThat(user.getRole()).isEqualTo(model.getRole());
                })
                .assertAll();
    }
}
