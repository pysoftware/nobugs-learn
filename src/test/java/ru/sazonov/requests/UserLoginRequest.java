package ru.sazonov.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    private String username;
    private String password;
}
