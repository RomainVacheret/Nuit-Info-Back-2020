package com.nuitdelinfo.app.groups.controller;

import java.util.Optional;

import com.nuitdelinfo.app.groups.service.GroupService;
import com.nuitdelinfo.app.model.UGroup;
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
public class GroupController{

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;


    @PutMapping("/group/{idg}/name")
    public String modifyGName(@RequestParam Long idg, String name){
        Optional<UGroup> group = groupService.getByIDG(idg);
        groupService.modifyGName(group, name);
        if(group.isPresent())
            return group.get().getName();
        return "";
    }

    @PostMapping("/group/{idg}/user/{id}")
    public void addUsertoGroupe(@RequestParam Long idg, @RequestParam Long id){
        Optional<UGroup> group = groupService.getByIDG(idg);
        Optional<User> user = userService.getByID(id);
        if(group.isPresent() && user.isPresent())
            groupService.addUsertoGroup(group, user);
    }

    @DeleteMapping("/group/{idg}/user/{id}")
    public void deleteUsertoGroup(@RequestParam Long idg, @RequestParam Long id){
        Optional<UGroup> group = groupService.getByIDG(idg);
        Optional<User> user = userService.getByID(id);
        if (group.isPresent() && user.isPresent())
            groupService.deleteUsertoGroup(group, user, user.get().getName());
    }

    @DeleteMapping("/group/{idg}/user/{id}")
    public void deleteGroupe(@RequestParam Long idg) {
        Optional<UGroup> group = groupService.getByIDG(idg);
        groupService.deleteGroupe(group);
    }

    @PostMapping("/group")
    public void addGroup(@RequestParam UGroup group){
        UGroup newgroup = group;  
        groupService.save(group);
    }
}