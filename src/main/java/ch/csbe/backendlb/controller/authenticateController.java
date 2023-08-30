package ch.csbe.backendlb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authenticate")
public class authenticateController {

    @PostMapping("")
    public String PostauthenticatePyid () {
        return "Hier wird ein Benutzer zu einem authentifizierten Benutzer";
    }



}
