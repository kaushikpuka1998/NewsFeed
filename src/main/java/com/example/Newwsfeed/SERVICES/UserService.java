package com.example.Newwsfeed.SERVICES;

import com.example.Newwsfeed.ENTITIES.Comment;
import com.example.Newwsfeed.ENTITIES.Post;
import com.example.Newwsfeed.ENTITIES.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    private final HashMap<String, User> userList = new HashMap<>();

    public User signUp(String username){
        User user = new User();
        user.setName(username);
        if(!userList.containsKey(username)){
            userList.put(username, user);
            return user;
        }
        return null;

    }

    public User login(String username){
        return userList.get(username);
    }

    public String follow(String username, String followUsername){
        User user = userList.get(username);
        User followUser = userList.get(followUsername);
        if(user == null || followUser == null){
            return "User not found";
        }
        if(user.getFollowing().contains(followUser)){
            return "Already following "+followUsername;
        }
        user.getFollowing().add(followUser);
        return "Followed "+followUsername+" by "+username;
    }

    public List<Post> getAllPosts(String username) {
        User user = userList.get(username);
        if(user == null){
            return null;
        }
        return user.getPost().stream().toList();
    }
}
