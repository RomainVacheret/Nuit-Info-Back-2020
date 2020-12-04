package com.nuitdelinfo.app.groups.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.groups.repository.GroupRepository;

import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
  
    private GroupRepository repository;


    @Override
    public void addUsertoGroup(Optional<UGroup> group, Optional<User> user) {
        Map<String,User> subs = new HashMap<>();
        if(user.isPresent() && group.isPresent()){
            subs.put(user.get().getName(), user.get());
            group.get().setSubscribers(subs);
        }
    }
    
    @Override
    public void deleteUsertoGroup(Optional<UGroup> group, Optional<User> user, String userName) {
        if (group.isPresent() && user.isPresent())
            group.get().getSubscribers().remove(userName);
    }

    @Override
    public void deleteGroupe(Optional<UGroup> group, String groupName){
        if(group.isPresent())
            group.get().getSubscribers().remove(groupName);
    }

    @Override
    public void modifyGName(Optional<UGroup> group,String groupName){
        if(group.isPresent())
            group.get().setName(groupName);       
    }
    

    @Override
    public Optional<UGroup> getByIDG(Long id){
        return repository.findById(id);
    }

    @Override
    public void save(UGroup group){
        repository.save(group);
    }
}


