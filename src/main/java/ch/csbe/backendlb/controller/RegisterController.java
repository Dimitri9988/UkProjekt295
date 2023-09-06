package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.user.UserEntitie;
import ch.csbe.backendlb.resources.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired UserService userService;

    @PostMapping("")
    public UserEntitie create(@RequestBody UserEntitie user) {

        return userService.create(user);
    }



}
