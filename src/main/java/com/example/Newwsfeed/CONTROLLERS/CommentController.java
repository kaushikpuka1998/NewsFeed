package com.example.Newwsfeed.CONTROLLERS;


import com.example.Newwsfeed.ENTITIES.Comment;
import com.example.Newwsfeed.ENTITIES.Post;
import com.example.Newwsfeed.ENTITIES.User;
import com.example.Newwsfeed.SERVICES.CommentService;
import com.example.Newwsfeed.SERVICES.PostService;
import com.example.Newwsfeed.SERVICES.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @PostMapping("/addComment/{postId}/{username}")
    public Comment addComment(@PathVariable String postId, @PathVariable String username, @RequestParam String content){
        Post post = postService.getPostById(postId);
        User user = userService.login(username);
        return commentService.addComment(post, user, content);
    }
}
