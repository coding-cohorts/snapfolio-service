package com.codingcohorts.controller;

import com.codingcohorts.dto.UserDTO;
import com.codingcohorts.dto.CreateUserDTO;
import com.codingcohorts.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


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

    // POST request to create a new user
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        UserDTO savedUser = userService.createUser(createUserDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
