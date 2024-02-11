package com.educatifu.api_analog_twitter.domain


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User {

    @Id
    String id
    String username
    String email
    String password // In a real application, ensure this is encrypted

    // Constructor, Getters, Setters, etc.

    List<String> followedUserIds = []

// ... Constructor, Getters, and Setters...
}

