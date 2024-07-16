package com.test.blogapp.service;

import com.test.blogapp.data.entity.Post;
import com.test.blogapp.data.request.UpdatePostRequest;

import java.util.List;

public interface PostService {

    Post getPostById(Long id);

    List<Post> getPostsByTitle(String title);

    List<Post> getPostsByAuthor(Long authorId);

    Post createPost(Post post, Long authorId);

    List<Post> getPosts();

    Post updatePost(UpdatePostRequest updPost, Long postId);

    void deletePost(Long postId);

}
