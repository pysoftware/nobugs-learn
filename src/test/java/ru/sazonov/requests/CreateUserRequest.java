package ru.sazonov.requests;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.sazonov.UserRoles;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@Data
@Accessors(chain=true)
public class CreateUserRequest {
    private String username;
    private String password;
    private String role;

    public static CreateUserRequest generateValidUserData(UserRoles role) {
        String allowedUserNameChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789._-";
        String allowedPasswordSpecialSymbols = "!&#";
        Random random = new Random();
        String validPassword = randomAlphabetic(1).toUpperCase()
                + randomAlphabetic(1).toLowerCase()
                + randomNumeric(1)
                + allowedPasswordSpecialSymbols.charAt(random.nextInt(allowedPasswordSpecialSymbols.length()))
                + randomAlphabetic(random.nextInt(4, 10));
        return new CreateUserRequest()
                .setUsername(RandomStringUtils.random(random.nextInt(3, 16), allowedUserNameChars))
                .setPassword(validPassword)
                .setRole(role.name());
    }
}
