package ru.sazonov.responses;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class AllUsersResponse {
    private long id;
    private String username;
    private String password;
    private String role;
    private String name;
    private List<Object> accounts;
}
