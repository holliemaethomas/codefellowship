package com.hollieThomasCodefellowship.codefellowship.controllers;


import com.hollieThomasCodefellowship.codefellowship.models.ApplicationUser;
import com.hollieThomasCodefellowship.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class RouteControllers {

    @Autowired
        ApplicationUserRepository applicationUserRepository;

    @Autowired
        PasswordEncoder encoder;

    @GetMapping("/")
        public String goHome(Principal p, Model m){
        if (p != null){
            m.addAttribute("username", p.getName());
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "home";
    }
}
//used some demo code for starters. I followed the videos a lot too.
