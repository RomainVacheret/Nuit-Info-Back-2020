package com.nuitdelinfo.app.post.service;

import java.util.Optional;

import com.nuitdelinfo.app.model.Post;
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
    public void addGroup(Optional<Post> post, Long idg) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addUser(Optional<Post> post, Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addDescription(Optional<Post> post, String description) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteDescription(Optional<Post> post, String description) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addComment(Optional<Post> post, Long idc) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteComment(Optional<Post> post, Long idc) {
        // TODO Auto-generated method stub

    }

    
    @Override
	public Optional<Post> getByID(Long id) {
		return repository.findById(id);
	}

    
}
