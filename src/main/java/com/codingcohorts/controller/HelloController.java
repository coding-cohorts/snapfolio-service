package com.codingcohorts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/ht")
    public String hello() {
        return "Yay Working!!!";
    }
}
