package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.category.categorydto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.categorydto.CategoryUpdateDto;
import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.ProductService;
import ch.csbe.backendlb.resources.user.UserEntitie;
import ch.csbe.backendlb.resources.user.UserService;
import ch.csbe.backendlb.resources.user.userdto.UserDetailDto;
import ch.csbe.backendlb.resources.user.userdto.UserMapper;
import ch.csbe.backendlb.resources.user.userdto.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("{id}")
    public UserDetailDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("{id}/promote")
    @Operation(summary = "aktualisirt ein user auf status authentifizirt", operationId = "putAdminstatus", description = "aktualisirt ein User auf ein Admin")
    public UserDetailDto update(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objekt(user) welcher auf Admin gesetzt wird")  @RequestBody UserUpdateDto user,@Parameter(description = "User(id) welcher autenifizirt wird") @PathVariable Long id) {
        return  userService.update(id, user );
    }
}
