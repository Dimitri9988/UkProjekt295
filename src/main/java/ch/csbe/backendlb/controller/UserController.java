package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resource.user.UserService;
import ch.csbe.backendlb.resource.user.userdto.UserDetailDto;
import ch.csbe.backendlb.resource.user.userdto.UserMapper;
import ch.csbe.backendlb.resource.user.userdto.UserUpdateDto;
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

    // verarbeited Get Anfrage und gibt Infos zu einem Benutzer anhand der Id
    @GetMapping("{id}")
    public UserDetailDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    // verarbeited Put Anfrage und aktualisirt einem Benutzer zu einenm Admin anhand der Id
    @PutMapping("{id}/promote")
    @Operation(summary = "aktualisiert einen Benutzerstatus auf 'Administrator'", operationId = "putAdminstatus", description = "aktualisiert einen Benutzerstatus auf 'Admin'")
    public UserDetailDto update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objekt (User), der auf 'Admin' gesetzt wird")
            @RequestBody UserUpdateDto user,
            @Parameter(description = "ID des Benutzers, der Admin wird")
            @PathVariable Long id
    ) {
        return userService.update(id, user);
    }
}