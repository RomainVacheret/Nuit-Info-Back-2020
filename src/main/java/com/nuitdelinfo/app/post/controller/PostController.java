package com.nuitdelinfo.app.post.controller;

import java.util.Optional;

import com.nuitdelinfo.app.model.Post;
import com.nuitdelinfo.app.post.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PostController {
    @Autowired
    private PostService postService;

    @PutMapping(path = "/post/{id}/name")
    public String modifyName(@RequestParam Long id, String name){
        Optional<Post> post = postService.getByID(id);
        postService.modifyName(post, name);
        if(post.isPresent())
            return post.get().getName();
        return "";
    }
}
