package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resource.login_regist.LoginRequestDto;
import ch.csbe.backendlb.resource.login_regist.TokenService;
import ch.csbe.backendlb.resource.login_regist.TokenWrapper;
import ch.csbe.backendlb.resource.user.UserEntitie;
import ch.csbe.backendlb.resource.user.UserService;
import ch.csbe.backendlb.resource.user.userdto.UserCreateDto;
import ch.csbe.backendlb.resource.user.userdto.UserShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    // Hier wird Post anfrage verarbeitet.
    @PostMapping("login")
    public TokenWrapper login(@RequestBody LoginRequestDto loginRequestDto) {
        // fiendet mit anmeldeinfos den Benutzer
        UserEntitie user = userService.getUserWithCredentials(loginRequestDto);

        if (user != null) {
            // Wen Benutzer gefunden ist gib ein Token zurück.
            TokenWrapper tokenWrapper = new TokenWrapper();
            String token = tokenService.generateToken(user);
            tokenWrapper.setToken(token);
            return tokenWrapper;
        } else {
            //Wenn keiner gefunden wird, gibt Null zurück.
            return null;
        }
    }

    // Regisrirt Benutzer und gibt ihn zurück.
    @PostMapping("register")
    public UserShowDto register(@RequestBody UserCreateDto userCreateDto) {
        return userService.register(userCreateDto);
    }
}