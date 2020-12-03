package com.nuitdelinfo.app.users.controller;

import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    
    @Autowired

    private UserService service;

    @PutMapping(path = "/User/{id}")
    public String modifyName(User user, String name){
        service.modifyName(user, name);
        return user.getName();
    }

    @PutMapping(path = "/User/{id}")
    public String modifyLastName(User user, String lastName){
        service.modifyLastName(user, lastName);
        return user.getLastName();
    }

    @PutMapping(path = "/User/{id}")
    public String modifyPseudo(User user, String pseudo){
        service.modifyPseudo(user, pseudo);
        return user.getPseudo();
    }
    @PutMapping(path = "/User/{id}")
    public String modifyEmail(User user, String email){
        service.modifyEmail(user, email);
        return user.getEmail();
    }

    @PostMapping(path = "/User/id/friend")
    public void addFriend(User user, User friend){
        service.addFriend(friend, user);
    }

    @DeleteMapping(path = "/User/id/friend")
    public void deleteFriend(User user, User friend){
        service.deleteFriend(user, friend.getName());
    }
}
