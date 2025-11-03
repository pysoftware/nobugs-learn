package ru.sazonov.responses;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateUserResponse {
    private long id;
    private String username;
    private String password;
    private String name;
    private String role;
    private List<Object> accounts;

    static void main() {
        System.out.println(System.getProperty("server"));
    }
}
