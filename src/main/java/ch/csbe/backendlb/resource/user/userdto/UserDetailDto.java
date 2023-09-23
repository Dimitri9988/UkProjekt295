package ch.csbe.backendlb.resource.user.userdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

    //DTO für die Detailansicht eines Benutzers
    @Data
    @Schema(description = "DTOs für die Detailansicht eines Benutzers")
    public class UserDetailDto {
        @NotNull
        @Schema(description = "Einmaliege Id des Benutzers")
        public Long id;
        @NotNull
        @Schema(description = "Vorname des Benutzers")
        public String firstName;
        @NotNull
        @Schema(description = "Nachname des Benutzers")
        public  String lastName;
        @NotNull
        @Schema(description = "Benutzername des Benutzers")
        public String username;
        @NotNull
        @Schema(description = "E-Mail des Benutzers")
        public String email;
        @NotNull
        @Schema(description = "Password des Benutzers")
        public String password;
        @NotNull
        @Schema(description = "Geburtstag(Alter) des Benutzers")
        public Date birthday;
        @NotNull
        @Schema(description = "Status ob der Benutzer Authentifizirt ist")
        public Boolean authenticated;

    }
