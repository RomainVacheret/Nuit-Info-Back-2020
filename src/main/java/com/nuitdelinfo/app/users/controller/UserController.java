package com.nuitdelinfo.app.users.controller;

import java.util.Optional;

import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService userService;
    //private GroupService groupService;

    @PutMapping(path = "/user/{id}/name")
    public String modifyName(@RequestParam Long id, String name){
        Optional<User> user = userService.getByID(id);
        userService.modifyName(user, name);
        if(user.isPresent())
            return user.get().getName();
        return "";
    }

    @PutMapping(path = "/user/{id}/lastname")
    public String modifyLastName(@RequestParam Long id , String lastName){
        Optional<User> user = userService.getByID(id);
        userService.modifyLastName(user, lastName);
        if(user.isPresent())
            return user.get().getLastName();
        return "";
    }

    @PutMapping(path = "/user/{id}/pseudo")
    public String modifyPseudo(@RequestParam Long id, String pseudo){
        Optional<User> user = userService.getByID(id);
        userService.modifyPseudo(user, pseudo);
        if(user.isPresent())
            return user.get().getPseudo();
        return "";
    }
    @PutMapping(path = "/user/{id}/email")
    public String modifyEmail(@RequestParam Long id, String email){
        Optional<User> user = userService.getByID(id);
        userService.modifyEmail(user, email);
        if(user.isPresent())
            return user.get().getEmail();
        return "";
    }

    @PostMapping(path = "/user/{id}/friend/{idf}")
    public void addFriend(@RequestParam Long id, @RequestParam Long idf){
        Optional<User> user = userService.getByID(id);
        Optional<User> friend = userService.getByID(idf);
        if( user.isPresent() && friend.isPresent() )
            userService.addFriend(user, friend);
    }

    @DeleteMapping(path = "/user/{id}/friend/{idf}")
    public void deleteFriend(@RequestParam Long id, @RequestParam Long idf){
        Optional<User> user = userService.getByID(id);
        Optional<User> friend = userService.getByID(idf);

        if( user.isPresent() && friend.isPresent() )
            userService.deleteFriend(user, friend.get().getName());
    }

    /* @PostMapping(path ="/user/{id}/group/{id}")
    public void addGroup(@RequestParam Long id,@RequestParam Long idg) {
        Optional<User> user = userService.getByID(id);
        Optional<Group> group = groupService.getByID(idg);
        userService.subscribe(user, group);
    } */

    @DeleteMapping(path ="/user/{id}/group/{id}")
    public void deleteGroup(@RequestParam Long id,@RequestParam Long idg) {
        Optional<User> user = userService.getByID(id);
        userService.unsubscribe(user, idg);
    }
    
    }
