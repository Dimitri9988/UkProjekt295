package ch.csbe.backendlb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("{id}")
    public String getUSerByid(@PathVariable String id){
        return "hier währe der Benutzer mit der id = " + id;
    }

    @PutMapping("{id}/promote")
    public String putUserPromoteByid(@PathVariable String id) {
        return "hier ist der Benutzer mit der id = " + id + " welcher jetzt authentifiziert ist";
    }
}
