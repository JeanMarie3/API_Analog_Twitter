package com.educatifu.api_analog_twitter.controller

import com.educatifu.api_analog_twitter.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping('/users')
class UserController {

    @Autowired
    private UserService userService

    // Endpoints for user operations such as register, edit, delete

    @PostMapping("/{userId}/follow/{followUserId}")
    void followUser(@PathVariable String userId, @PathVariable String followUserId) {
        userService.followUser(userId, followUserId)
    }

    @DeleteMapping("/{userId}/follow/{unfollowUserId}")
    void unfollowUser(@PathVariable String userId, @PathVariable String unfollowUserId) {
        userService.unfollowUser(userId, unfollowUserId)
    }

// ... other endpoints ...

}

