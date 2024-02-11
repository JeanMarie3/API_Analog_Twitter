package com.educatifu.api_analog_twitter.controller

import com.educatifu.api_analog_twitter.domain.Post
import com.educatifu.api_analog_twitter.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping('/posts')
class PostController {

    // Endpoints for post operations such as create, edit, delete

    @Autowired
    private PostService postService

    @GetMapping("/")
    List<Post> getAllPosts() {
        postService.getAllPosts()
    }

    @PostMapping("/")
    Post createPost(@RequestBody Post post) {
        postService.createPost(post)
    }

    @GetMapping("/{id}")
    Post getPostById(@PathVariable String id) {
        postService.getPostById(id)
    }

    @DeleteMapping("/{id}")
    void deletePost(@PathVariable String id) {
        postService.deletePost(id)
    }

    // Additional endpoints for updating posts, handling likes, etc.

    @PutMapping("/{id}")
    Post updatePost(@PathVariable String id, @RequestBody Post post) {
        postService.updatePost(id, post)
    }


    //============================================================

    @PostMapping("/{postId}/likes")
    void likePost(@PathVariable String postId, @RequestBody String userId) {
        postService.likePost(postId, userId)
    }

    @DeleteMapping("/{postId}/likes/{userId}")
    void unlikePost(@PathVariable String postId, @PathVariable String userId) {
        postService.unlikePost(postId, userId)
    }

    @PostMapping("/{postId}/comments")
    void addCommentToPost(@PathVariable String postId, @RequestBody Map<String, String> commentData) {
        String userId = commentData.get("userId")
        String content = commentData.get("content")
        postService.addCommentToPost(postId, content, userId)
    }

// ... other endpoints ...
}

