package com.nuitdelinfo.app.post.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.nuitdelinfo.app.model.Comment;
import com.nuitdelinfo.app.model.Post;
import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.post.repository.PostRepository;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository repository;

    @Override
    public void modifyName(Optional<Post> post, String name) {
        if( post.isPresent())
            post.get().setName(name);

    }

    @Override
	public Optional<Post> getByID(Long id) {
		return repository.findById(id);
	}

    @Override
    public void modifyGroup(Optional<Post> post, Optional<UGroup> group) {
        if(post.isPresent() && group.isPresent())
            post.get().setGroup(group.get());

    }

    @Override
    public void modifyUser(Optional<Post> post, Optional<User> user) {
        if(post.isPresent() && user.isPresent())
            post.get().setUser(user.get());

    }

    @Override
    public void modifyDescription(Optional<Post> post, String description) {
        if(post.isPresent())
            post.get().setDescription(description);

    }

    @Override
    public void deleteDescription(Optional<Post> post) {
        if(post.isPresent())
            post.get().setDescription("");

    }

    @Override
    public void addComment(Optional<Post> post, Optional<Comment> comment) {
        if(post.isPresent() && comment.isPresent())
            post.map(p -> p.getComments().add(comment.get()));

    }

    @Override
    public void deleteComment(Optional<Post> post, Long idc) {
        if(post.isPresent()){
            post.get().getComments().forEach(c ->{
                if(c.getId() == idc)
                    post.get().getComments().remove(c);
            });
        }

    }

    @Override
    public String displayName(Optional<Post> post) {
        if(post.isPresent())
            return post.get().getName();
        return null;
    }

    @Override
    public UGroup displayGroup(Optional<Post> post) {
        if(post.isPresent())
            return post.get().getGroup();
        return null;
    }

    @Override
    public User displayUser(Optional<Post> post) {
        if(post.isPresent())
            return post.get().getUser();
        return null;
    }

    @Override
    public String displayDescription(Optional<Post> post) {
        if(post.isPresent())
            return post.get().getDescription();
        return null;
    }

    @Override
    public Set<Comment> displayComments(Optional<Post> post) {
        Set<Comment> rstNull = new HashSet<>();
        if(post.isPresent())
            return post.get().getComments();
        return rstNull;
    }

    
}
