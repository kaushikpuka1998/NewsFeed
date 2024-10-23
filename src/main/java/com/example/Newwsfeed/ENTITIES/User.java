package com.example.Newwsfeed.ENTITIES;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private Set<Post> post = new HashSet<>();
    private Set<User> following = new HashSet<>();
}
