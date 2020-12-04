package com.nuitdelinfo.app.post.service;

import java.util.Optional;
import java.util.Set;

import com.nuitdelinfo.app.model.Comment;
import com.nuitdelinfo.app.model.Post;
import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.model.User;

public interface PostService {
    void modifyName(Optional<Post> post, String name);
    void modifyGroup(Optional<Post> post, Optional<UGroup> group);
    void modifyUser(Optional<Post> post,Optional<User> user);

    void modifyDescription(Optional<Post> post, String description);
    void deleteDescription(Optional<Post> post);

    void addComment(Optional<Post> post,Optional<Comment> comment);
    void deleteComment(Optional<Post> post, Long idc);
    
    Optional<Post> getByID(Long id);

    String displayName(Optional<Post> post);
    UGroup displayGroup(Optional<Post> post);
    User displayUser(Optional<Post> post);
    String displayDescription(Optional<Post> post);
    Set<Comment> displayComments(Optional<Post> post);
}