package com.educatifu.api_analog_twitter.repository

import com.educatifu.api_analog_twitter.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository extends MongoRepository<User, String> {

    // Custom database queries if needed
}
