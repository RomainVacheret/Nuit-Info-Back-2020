package com.nuitdelinfo.app.post.service;

import java.util.Optional;

import com.nuitdelinfo.app.model.Post;

public interface PostService {
    void modifyName(Optional<Post> post, String name);
    void addGroup(Optional<Post> post, Long idg);
    void addUser(Optional<Post> post, Long id);

    void addDescription(Optional<Post> post, String description);
    void deleteDescription(Optional<Post> post, String description);

    void addComment(Optional<Post> post,Long idc);
    void deleteComment(Optional<Post> post,Long idc);
    
    Optional<Post> getByID(Long id);
}