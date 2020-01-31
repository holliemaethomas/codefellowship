package com.hollieThomasCodefellowship.codefellowship.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

}
