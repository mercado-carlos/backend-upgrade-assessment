package com.assessment.upgradeassessment.controllers;

import java.util.*;

import com.assessment.upgradeassessment.models.UserModel;
import com.assessment.upgradeassessment.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /* GET */
    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    /* GET By ID */
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long idUser) {
        return this.userService.getUserById(idUser);
    }

    /* POST */
    @PostMapping()
    public UserModel postUser(@RequestBody UserModel profileModel) {
        return this.userService.postUser(profileModel);
    }

    /* PUT */
    @PutMapping(path = "/{id}")
    public UserModel putUser(@RequestBody UserModel userModel,
            @PathVariable("id") Long idUser) {
        return this.userService.putUser(userModel, idUser);
    }

    /* DELETE */
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long idUser) {
        boolean ok = this.userService.deleteUser(idUser);

        if (ok) {
            return "The next user has been deleted: " + idUser;
        } else {
            return "The next user cannot be deleted: " + idUser;
        }
    }
}
