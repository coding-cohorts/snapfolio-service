package com.codingcohorts.controller;

import com.codingcohorts.dto.UserDTO;
import com.codingcohorts.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{user_id}")
    public UserDTO getUser(@PathVariable Long user_id) {
        return userService.getUserById(user_id);
    }
}
