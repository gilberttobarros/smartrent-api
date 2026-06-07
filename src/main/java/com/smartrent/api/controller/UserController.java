package com.smartrent.api.controller;

import com.smartrent.api.entity.User;
import com.smartrent.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll (){
        return userService.findAll();
    }

    @PostMapping
    public User save (@RequestBody User user){
        return userService.save(user);
    }
}
