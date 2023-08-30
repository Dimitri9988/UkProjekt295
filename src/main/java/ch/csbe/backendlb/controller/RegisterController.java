package ch.csbe.backendlb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    @PostMapping("")
    public String PostRegisterPyid () {
        return "Hier wird enîn Benutzer neu Erstellt";
        }



}
