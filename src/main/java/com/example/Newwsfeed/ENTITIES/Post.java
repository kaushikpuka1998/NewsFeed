package com.example.Newwsfeed.ENTITIES;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Post {
    private String id;
    private String title;
    private int upvotes = 0;
    private int downvotes = 0;
    private HashMap<String, Boolean> upvotedUsers = new HashMap<>();
    private HashMap<String, Boolean> downvotedUsers = new HashMap<>();
    private LocalDateTime timeStamp;
    private List<Comment> comments = new ArrayList<>();
}
