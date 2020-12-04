package com.nuitdelinfo.app.post.controller;

import java.util.Optional;
import java.util.Set;

import com.nuitdelinfo.app.model.Comment;
import com.nuitdelinfo.app.model.Post;
import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.post.service.PostService;
import com.nuitdelinfo.app.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@CrossOrigin
public class PostController {
    @Autowired
    private PostService postService;
    //private UGroupService groupService;
    //private CommentService commentService;
    private UserService userService;

    @PutMapping("/post/{id}/name")
    public void modifyName(@RequestParam Long id, String name){
        Optional<Post> post = postService.getByID(id);
        postService.modifyName(post, name);
    }

   /*  @PostMapping("/group/{idg}/post/{idp}")
    public void modifyGroup(@RequestParam Long idg,@RequestParam Long idp) {
        Optional<Post> post = postService.getByID(idp);
        Optional<UGroup> group = groupService.getByID(idg);
        postService.modifyGroup(post, group);
    } */
    
    @PostMapping("/user/{id}/post/{idp}")
    public void modifyUser(@RequestParam Long id, @RequestParam Long idp) {
        Optional<Post> post = postService.getByID(idp);
        Optional<User> user = userService.getByID(id);
        postService.modifyUser(post, user);
    }

    @PutMapping("/post/{idp}/description")
    public void modifyDescription(@RequestParam Long id, String description){
        Optional<Post> post = postService.getByID(id);
        postService.modifyDescription(post, description);
    }

    @DeleteMapping("/post/{idp}/description")
    public void deleteDescription(@RequestParam Long id){
        Optional<Post> post = postService.getByID(id);
        postService.deleteDescription(post);
    }

    /* @PostMapping("/post/{idp}/comment/{idc}")
    public void addComment(@RequestParam Long idp,@RequestParam Long idc){
        Optional<Post> post = postService.getByID(idp);
        Optional<Comment> comment = commentService.getByID(idc);
        postService.addComment(post, comment);
    } */
    @DeleteMapping("/post/{idp}/comment/{idc}")
    public void deleteComment(@RequestParam Long idp,@RequestParam Long idc){
        Optional<Post> post = postService.getByID(idp);
        postService.deleteComment(post, idc);
    }

    @GetMapping("/post/{idp}/name")
    public String displayName(@RequestParam Long idp){
        Optional<Post> post = postService.getByID(idp);
        return postService.displayName(post);
    }
    @GetMapping("/post/{idp}/group")
    public UGroup displayGroup(@RequestParam Long idp, @RequestParam Long idg){
        Optional<Post> post = postService.getByID(idp);
        return postService.displayGroup(post);
    }
    @GetMapping("/post/{idp}/user")
    public User displayUser(@RequestParam Long idp){
        Optional<Post> post = postService.getByID(idp);
        return postService.displayUser(post);
    }
    @GetMapping("/post/{idp}/description")
    public String displayDescription(@RequestParam Long idp){
        Optional<Post> post = postService.getByID(idp);
        return postService.displayDescription(post);
    }
    @GetMapping("/post/{idp}/comments")
    public Set<Comment> displayComments(@RequestParam Long idp){
        Optional<Post> post = postService.getByID(idp);
        return postService.displayComments(post);
    }
}
