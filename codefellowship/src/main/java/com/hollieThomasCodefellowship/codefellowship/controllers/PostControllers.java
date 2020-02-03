package com.hollieThomasCodefellowship.codefellowship.controllers;

import com.hollieThomasCodefellowship.codefellowship.models.ApplicationUser;
import com.hollieThomasCodefellowship.codefellowship.models.ApplicationUserRepository;
import com.hollieThomasCodefellowship.codefellowship.models.Post;
import com.hollieThomasCodefellowship.codefellowship.models.PostRepository;
import com.hollieThomasCodefellowship.codefellowship.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class PostControllers {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/addpost")
    public String getAddPostPage(Principal p, Model m){
        m.addAttribute("username", p.getName());
        return "addpost";
    }

    @PostMapping("/addpost")
    public RedirectView createPost (String body, Model m, Principal p){
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Post post = new Post(body, createdAt.toString(),
                applicationUserRepository.findByUsername(p.getName()));

        postRepository.save(post);
        return new RedirectView("/profile");
    }

    @DeleteMapping("/profile/{id}")
    public RedirectView deletePost(@PathVariable long id, Principal p){
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        Post u = postRepository.getOne(id);
        if (user.getPosts().contains(u)) {
            postRepository.deleteById(id);
        }
        return new RedirectView("/profile");
    }

    @GetMapping("/viewposts")
        public String getAllPosts(Principal p, Model m){
            m.addAttribute("username", p.getName());
            List<Post> allPosts = postRepository.findAll();
            m.addAttribute("allposts", allPosts);
            return "viewposts";
    }





}
