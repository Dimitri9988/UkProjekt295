package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired ProductService userService;

    @GetMapping("/{id}")
    public ProductEntitie getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("{id}/promote")
    public String putUserPromoteByid(@PathVariable String id) {
        return "hier ist der Benutzer mit der id = " + id + " welcher jetzt authentifiziert ist";
    }
}
