package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.login.LoginRequestDto;
import ch.csbe.backendlb.resources.login.TokenService;
import ch.csbe.backendlb.resources.login.TokenWrapper;
import ch.csbe.backendlb.resources.user.UserEntitie;
import ch.csbe.backendlb.resources.user.UserService;
import ch.csbe.backendlb.resources.user.userdto.UserCreateDto;
import ch.csbe.backendlb.resources.user.userdto.UserShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("login")
    public TokenWrapper login(@RequestBody LoginRequestDto loginRequestDto) {
        UserEntitie user = userService.getUserWithCredentials(loginRequestDto);

        if (user != null) {
            TokenWrapper tokenWrapper = new TokenWrapper();
            String token = tokenService.generateToken(user);
            tokenWrapper.setToken(token);
            return tokenWrapper;
        } else {
            // Errorhandling.
            // Either return 401 or 400
            return null;
        }

    }

    @PostMapping("register")
    public UserShowDto register(@RequestBody UserCreateDto userCreateDto) {

        return userService.register(userCreateDto);
    }
}
