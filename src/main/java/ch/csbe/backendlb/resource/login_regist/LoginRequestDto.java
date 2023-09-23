package ch.csbe.backendlb.resource.login_regist;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
