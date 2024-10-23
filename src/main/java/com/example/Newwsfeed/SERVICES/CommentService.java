package com.example.Newwsfeed.SERVICES;

import com.example.Newwsfeed.ENTITIES.Comment;
import com.example.Newwsfeed.ENTITIES.Post;
import com.example.Newwsfeed.ENTITIES.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    public Comment addComment(Post post, User user, String content){
        Comment comment = new Comment();
        comment.setTitle(content);
        comment.getCommenedUsers().put(user.getName(), true);
        comment.setId(Integer.parseInt(String.valueOf(post.getComments().size()+1)));
        comment.setTimeStamp(LocalDateTime.now());
        post.getComments().add(comment);
        return comment;
    }

}
