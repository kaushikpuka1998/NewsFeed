package com.example.Newwsfeed.SERVICES;

import com.example.Newwsfeed.ENTITIES.Post;
import com.example.Newwsfeed.ENTITIES.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    List<Post> postsList = new ArrayList<>();

    @Autowired
    private UserService userService;

    public Post createPost(User user, String title){
        Post post = new Post();
        post.setTitle(title);
        post.setId(String.valueOf(postsList.size()+1));
        post.setTimeStamp(LocalDateTime.now());
        user.getPost().add(post);
        postsList.add(post);
        return post;
    }

    public String upVotePost(String postId, String username){
        Post post = postsList.stream().filter(p -> p.getId().equals(postId)).findFirst().orElse(null);
        User user =  userService.login(username);
        if (post != null) {
            if (post.getUpvotedUsers().containsKey(user.getName())) {
                return "User has already upvoted this post";
            }
            else if(post.getDownvotedUsers().containsKey(user.getName())){
                post.getDownvotedUsers().remove(user.getName());
                post.getUpvotedUsers().put(user.getName(), true);
                post.setUpvotes(post.getUpvotes() + 1);
                post.setDownvotes(post.getDownvotes() - 1);
                return "Upvoted on post " + postId;
            }
            else {
                post.getUpvotedUsers().put(user.getName(), true);
                post.setUpvotes(post.getUpvotes() + 1);
                return "Upvoted on post " + postId;
            }
        }
        return "Post not found";
    }

    public String downVotePost(String postId,String username){
        Post post = postsList.stream().filter(p -> p.getId().equals(postId)).findFirst().orElse(null);
        User user =  userService.login(username);
        if (post != null) {
            if (post.getDownvotedUsers().containsKey(user.getName())) {
                return "User has already downvoted this post";
            }
            else if(post.getUpvotedUsers().containsKey(user.getName())){
                post.getDownvotedUsers().put(user.getName(), true);
                post.getUpvotedUsers().remove(user.getName());
                post.setUpvotes(post.getUpvotes() - 1);
                post.setDownvotes(post.getDownvotes() + 1);
                return "downvoted on post " + postId;
            }
            else {
                post.getDownvotedUsers().put(user.getName(), true);
                post.setDownvotes(post.getUpvotes() + 1);
                return "downvoted on post " + postId;
            }
        }
        return "Post not found";
    }

    public Post getPostById(String postId){
        return postsList.stream().filter(p -> p.getId().equals(postId)).findFirst().orElse(null);
    }

}
