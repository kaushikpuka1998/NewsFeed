package com.example.Newwsfeed.ENTITIES;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class Comment {
    private int id;
    HashMap<String,Boolean> commenedUsers = new HashMap<>();
    private String title;
    private int upvotes;
    private int downvotes;
    private LocalDateTime timeStamp;
}
