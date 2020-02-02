
package com.hollieThomasCodefellowship.codefellowship.controllers;

import com.hollieThomasCodefellowship.codefellowship.models.ApplicationUser;
import com.hollieThomasCodefellowship.codefellowship.models.ApplicationUserRepository;
import com.hollieThomasCodefellowship.codefellowship.*;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;




@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signup (String username, String password, String
            firstName, String lastName, Date dateOfBirth, String bio){
            if (applicationUserRepository.findByUsername(username) == null) {
                ApplicationUser newUser = new ApplicationUser(username,
                        encoder.encode(password),
                        firstName,
                        lastName,
                        dateOfBirth,
                        bio);
                applicationUserRepository.save(newUser);

                Authentication authentication = new  UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return new RedirectView("/profile");

            } else { return new RedirectView("/signup/?taken=true");}
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
//    @GetMapping("/login")
//    public String getProfile(Principal p, Model m){
//        return "profile";
//    }


    @GetMapping("/user/{id}")
        public String getUser(@PathVariable Long id, Principal p, Model m){
            m.addAttribute("username", p.getName());
            ApplicationUser user = applicationUserRepository.getOne(id);
            m.addAttribute("user", user);
            return "userinfo";
        }


    @GetMapping("/viewusers")
    public String viewUser(Principal p, Model m){
        m.addAttribute("username", p.getName());
        List<ApplicationUser> users = applicationUserRepository.findAll();
        m.addAttribute("usersProfile", users);
        return "viewusers";
    }

    @PostMapping("/following")
    public RedirectView userIfollow (long followingID, Principal p, Model m){
        ApplicationUser userImFollowing = applicationUserRepository.getOne(followingID);
        ApplicationUser userFollowingMe = applicationUserRepository.findByUsername(p.getName());
        if (!userImFollowing.getUsersIfollow().contains(userFollowingMe)) {
            userImFollowing.getUsersIfollow().add(userFollowingMe);
        }
        applicationUserRepository.save(userFollowingMe);
        return new RedirectView("/profile");
    }


        }







