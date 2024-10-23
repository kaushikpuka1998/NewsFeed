package com.example.Newwsfeed.CONTROLLERS;

import com.example.Newwsfeed.ENTITIES.Post;
import com.example.Newwsfeed.ENTITIES.User;
import com.example.Newwsfeed.SERVICES.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestParam String username){
        return userService.signUp(username);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username){
        return userService.login(username);
    }

    @PostMapping("/follow")
    public String follow(@RequestParam String username, @RequestParam String followUsername){
        return userService.follow(username, followUsername);
    }

    @GetMapping("/allPosts/{username}")
    public List<Post> getAllPosts(@PathVariable String username){
        return userService.getAllPosts(username);
    }
}
