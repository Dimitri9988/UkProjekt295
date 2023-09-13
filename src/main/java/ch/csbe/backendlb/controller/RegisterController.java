package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.user.UserEntitie;
import ch.csbe.backendlb.resources.user.UserService;
import ch.csbe.backendlb.resources.user.userdto.UserCreateDto;
import ch.csbe.backendlb.resources.user.userdto.UserDetailDto;
import ch.csbe.backendlb.resources.user.userdto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("")
    public UserDetailDto create(@RequestBody UserCreateDto user) {

        return userService.create(user);
    }



}
