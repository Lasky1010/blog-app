package com.test.blogapp.service.impl;

import com.test.blogapp.data.entity.Post;
import com.test.blogapp.data.repository.AuthorRepository;
import com.test.blogapp.data.repository.PostRepository;
import com.test.blogapp.data.request.UpdatePostRequest;
import com.test.blogapp.exception.AuthorNotFoundException;
import com.test.blogapp.exception.PostNotFoundException;
import com.test.blogapp.service.PostService;
import com.test.blogapp.util.PostUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public List<Post> getPostsByTitle(String title) {
        var posts = postRepository.findByTitleContainingIgnoreCase(title);
        if (posts.isEmpty()) {
            throw new PostNotFoundException();
        }
        return posts;
    }

    @Override
    public List<Post> getPostsByAuthor(Long authorId) {
        var posts = postRepository.findByAuthorId(authorId);
        if (posts.isEmpty()) {
            throw new PostNotFoundException();
        }
        return posts;

    }

    @Override
    public Post createPost(Post post, Long authorId) {
        var author = authorRepository.findById(authorId).orElseThrow(AuthorNotFoundException::new);
        post.setAuthor(author);
        author.getPosts().add(post);
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(UpdatePostRequest updPost, Long postId) {
        var post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        return postRepository.save(PostUtil.updatePost(updPost, post));
    }

    @Override
    public void deletePost(Long postId) {
        var post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        postRepository.delete(post);
    }
}
