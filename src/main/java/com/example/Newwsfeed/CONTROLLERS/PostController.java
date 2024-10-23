package com.example.Newwsfeed.CONTROLLERS;

import com.example.Newwsfeed.ENTITIES.Post;
import com.example.Newwsfeed.SERVICES.PostService;
import com.example.Newwsfeed.SERVICES.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Post createPost(@RequestParam String username, @RequestParam String content){
        return postService.createPost(userService.login(username), content);
    }

    @PostMapping("/upvote")
    public String upvote( @RequestParam String postId, @RequestParam String username){
        return postService.upVotePost(postId,username);
    }

    @PostMapping("/downvote")
    public String downvote( @RequestParam String postId, @RequestParam String username){
        return postService.downVotePost(postId,username);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable String id){
        return postService.getPostById(id);
    }





}
