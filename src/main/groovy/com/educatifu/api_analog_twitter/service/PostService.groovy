package com.educatifu.api_analog_twitter.service

import com.educatifu.api_analog_twitter.domain.Post
import com.educatifu.api_analog_twitter.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.educatifu.api_analog_twitter.domain.Post.Comment

@Service
class PostService {

    @Autowired
    private PostRepository postRepository

    // Methods to handle post operations such as create, edit, delete

    @Autowired
    PostRepository postRepository

    List<Post> getAllPosts() {
        postRepository.findAll()
    }

    Post createPost(Post post) {
        postRepository.save(post)
    }

    Post getPostById(String id) {
        postRepository.findById(id).orElse(null)
    }

    void deletePost(String id) {
        postRepository.deleteById(id)
    }

    // Additional methods for updating posts, handling likes, etc.

    @Transactional
    Post updatePost(String id, Post updatedPost) {
        Post post = postRepository.findById(id).orElse(null)
        if (post) {
            post.setContent(updatedPost.content)
            postRepository.save(post)
        }
        return post
    }

    //=========================================================================

    @Transactional
    void likePost(String postId, String userId) {
        Post post = postRepository.findById(postId).orElse(null)
        if (post && !post.likes.contains(userId)) {
            post.likes.add(userId)
            postRepository.save(post)
        }
    }

    @Transactional
    void unlikePost(String postId, String userId) {
        Post post = postRepository.findById(postId).orElse(null)
        if (post) {
            post.likes.remove(userId)
            postRepository.save(post)
        }
    }

    @Transactional
    void addCommentToPost(String postId, String content, String userId) {
        Post post = postRepository.findById(postId).orElse(null)
        if (post) {
            Comment comment = new Comment()
            comment.userId = userId
            comment.content = content
            post.comments.add(comment)
            postRepository.save(post)
        }
    }

// ... other service methods ...


}

