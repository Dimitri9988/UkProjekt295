package ch.csbe.backendlb.resources.user.userdto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class UserUpdateDto {
    public Long id;
    public String firstName;
    public  String lastName;
    public String username;
    public String email;
    public String password;
    public Date birthday;
    public Boolean authenticated;
}
