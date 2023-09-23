package ch.csbe.backendlb.resource.login_regist;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {
    // Email feld beim einlogen
    @NotNull
    private String email;
    // Password feld beim einlogen
    @NotNull
    private String password;
}
