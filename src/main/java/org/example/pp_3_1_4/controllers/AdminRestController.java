package org.example.pp_3_1_4.controllers;

import org.example.pp_3_1_4.model.Role;
import org.example.pp_3_1_4.model.User;
import org.example.pp_3_1_4.service.RoleService;
import org.example.pp_3_1_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
public class AdminRestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @PostMapping(value = "/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId((long)id);
        userService.update(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value ="/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        User user = userService.findById(id);
        userService.delete(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/roles")
    public List<Role> showAllRoles() {
        return roleService.getRoles();
    }



}
