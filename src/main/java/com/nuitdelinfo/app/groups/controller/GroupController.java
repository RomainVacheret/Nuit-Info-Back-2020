package com.nuitdelinfo.app.model;


import com.nuitdelinfo.app.groups.service.GroupService;
import com.nuitdelinfo.app.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jdk.jfr.internal.Repository;


@RestController
@CrossOrigin
public class GroupController{

    @Autowired
    private GroupService groupService;


    @PutMapping(path = "/group/{idg}/name")
    public String modifyGName(@RequestParam Long idg, String name){
        Optional<UGroup> group = groupService.getByIDG(idg);
        groupService.modifyGName(group, name);
        if(group.isPresent())
            return group.get().getName();
        return "";
    }

    @PostMapping(path = "/group/{idg}/user/{id}")
    public void addUsertoGroupe(@RequestParam Long idg, @RequestParam Long id){
        Optional<UGroup> group = groupService.getByIDG(idg);
        Optional<User> user = userService.getByID(id);
        if(group.isPresent() && user.isPresent())
            groupService.addUsertoGroup(group, friend);
    }

    @DeleteMapping(path = "/group/{idg}/user/{id}")
    public void deleteUsertoGroup(@RequestParam Long idg, @RequestParam Long id){
        Optional<Ugroup> group = groupService.getByID(idg);
        Optional<User> user = userService.getByID(id);
        if(group.isPresent() && user.isPresent())
            groupService.deleteUsertoGroup(group, friend,user.get().getName());
    }

    @DeleteMapping(path = "/group/{idg}/user/{id}")
    public void deleteGroupe(@RequestParam Long idg){
        Optional<UGroup> group = groupService.getByID(idg);
        groupService.deleteGroupe(group, group.get().getName());
    }


    @PostMapping(path = "/group")
    public void addGroup(@RequestParam UGroup group){
        UGroup newgroup = group;  
        groupService.save(group);
    }



}