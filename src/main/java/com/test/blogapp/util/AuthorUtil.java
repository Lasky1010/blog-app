package com.test.blogapp.util;

import com.test.blogapp.data.entity.Author;
import com.test.blogapp.data.request.UpdateAuthorRequest;

public class AuthorUtil {

    public static Author updateAuthor(UpdateAuthorRequest updAuthor, Author oldAuthor) {
        if (!oldAuthor.getCountry().equals(updAuthor.getCountry()) && !updAuthor.getCountry().isEmpty()) {
            oldAuthor.setCountry(updAuthor.getCountry());
        }
        if (!oldAuthor.getName().equals(updAuthor.getName()) && !updAuthor.getName().isEmpty()) {
            oldAuthor.setName(updAuthor.getName());
        }
        return oldAuthor;

    }
}
