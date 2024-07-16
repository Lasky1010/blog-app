package com.test.blogapp.util;

import com.test.blogapp.data.entity.Post;
import com.test.blogapp.data.request.UpdatePostRequest;

public class PostUtil {

    public static Post updatePost(UpdatePostRequest updPost, Post oldPost) {
        if (!oldPost.getTitle().equals(updPost.getTitle()) && !updPost.getTitle().isEmpty()) {
            oldPost.setTitle(updPost.getTitle());
        }
        if (!oldPost.getContent().equals(updPost.getContent()) && !updPost.getContent().isEmpty()) {
            oldPost.setContent(updPost.getContent());
        }
        return oldPost;

    }
}
