package com.educatifu.api_analog_twitter.service

import com.educatifu.api_analog_twitter.domain.User
import com.educatifu.api_analog_twitter.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService {

    @Autowired
    private UserRepository userRepository

    // Methods to handle user operations such as create, edit, delete

    // ... UserService class ...

    @Transactional
    void followUser(String userId, String followUserId) {
        User user = userRepository.findById(userId).orElse(null)
        User followUser = userRepository.findById(followUserId).orElse(null)
        if (user && followUser && !user.followedUserIds.contains(followUserId)) {
            user.followedUserIds.add(followUserId)
            userRepository.save(user)
        }
    }

    @Transactional
    void unfollowUser(String userId, String unfollowUserId) {
        User user = userRepository.findById(userId).orElse(null)
        if (user) {
            user.followedUserIds.remove(unfollowUserId)
            userRepository.save(user)
        }
    }

// ... other service methods ...

}

