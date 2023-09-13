package ch.csbe.backendlb.resources.user.userdto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;


    @Data
    public class UserDetailDto {
        @NotNull
        public Long id;
        @NotNull
        public String firstName;
        @NotNull
        public  String lastName;
        @NotNull
        public String username;
        @NotNull
        public String email;
        @NotNull
        public String password;
        @NotNull
        public Date birthday;
        @NotNull
        public Boolean authenticated;

    }

