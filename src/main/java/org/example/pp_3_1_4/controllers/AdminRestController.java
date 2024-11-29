//package org.example.pp_3_1_4.controllers;
//
//import org.example.pp_3_1_4.model.Role;
//import org.example.pp_3_1_4.model.User;
//import org.example.pp_3_1_4.service.RoleService;
//import org.example.pp_3_1_4.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin")
//@EnableAutoConfiguration
//public class AdminRestController {
//
//    private UserService userService;
//    private RoleService roleService;
//
//    @Autowired
//    public AdminRestController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping
//    public List<User> showAllUsers() {
//        return userService.getAllUsers();
//    }
//
//
//    @PostMapping(value = "/saveUser")
//    public User saveUser(@RequestBody User user) {
//        userService.add(user);
//        return user;
//    }
//
//    @PutMapping(value = "/updateUser/{id}")
//    public User updateUser(@PathVariable int id, @RequestBody User user) {
//        user.setId((long)id);
//        userService.update(user);
//        return user;
//    }
//
//    @DeleteMapping(value ="/deleteUser/{id}")
//    public String deleteUser(@PathVariable int id) {
//        User user = userService.findById(id);
//        userService.delete(user);
//        return "User deleted";
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable int id) {
//        return userService.findById(id);
//    }
//
//    @GetMapping("/roles")
//    public List<Role> showAllRoles() {
//        return roleService.getRoles();
//    }
//
//
//
//}
