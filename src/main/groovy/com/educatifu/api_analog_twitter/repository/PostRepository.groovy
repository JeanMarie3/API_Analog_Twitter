package com.educatifu.api_analog_twitter.repository

import com.educatifu.api_analog_twitter.domain.Post
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface PostRepository extends MongoRepository<Post, String> {

    // Custom database queries if needed
    List<Post> findByUserId(String userId)

    List<Post> findAllByIdInOrderByCreatedAtDesc(List<String> userIds)
    List<Post> findByUserIdOrderByCreatedAtDesc(String userId)

    @Query("{ 'userId': ?0 }")
    List<Post> findPostsByUserId(String userId)
}

