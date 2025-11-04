package ru.sazonov.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLoginResponse {
    public String role;
    public String username;
}
