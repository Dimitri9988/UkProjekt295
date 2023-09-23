package ch.csbe.backendlb.resource.user.userdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// DTO zum Aktualisirten eines Benutzers
@Getter
@Setter
@Data

@Schema(description = "DTOs für das updaten eines Benutzers")
public class UserUpdateDto {
    @Schema(description = "Vorname des Benutzers")
    public String firstName;
    @Schema(description = "Nachname des Benutzers")
    public String lastName;
    @Schema(description = "Benutzername des Benutzers")
    public String username;
    @Schema(description = "E-Mail des Benutzers")
    public String email;
    @Schema(description = "Password des Benutzers")
    public String password;
    @Schema(description = "Geburtstag(Alter) des Benutzers")
    public Date birthday;
    @Schema(description = "Status ob der Benutzer Authentifizirt ist")
    public Boolean authenticated;
}
