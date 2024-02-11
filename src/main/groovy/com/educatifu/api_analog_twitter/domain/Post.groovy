package com.educatifu.api_analog_twitter.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Post {

    @Id
    String id
    String userId
    String content
    Date createdAt = new Date()
    List<String> likes = [] // assuming likes are user IDs
    List<Comment> comments = []

    static class Comment {
        String userId
        String content
        Date createdAt = new Date()
    }

    // Constructor, Getters, and Setters...


}
