package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.ProductService;
import ch.csbe.backendlb.resources.user.UserEntitie;
import ch.csbe.backendlb.resources.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public UserEntitie getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PutMapping("{id}/promote")
    public String putUserPromoteByid(@PathVariable String id) {
        return "hier ist der Benutzer mit der id = " + id + " welcher jetzt authentifiziert ist";
    }
}
