package com.nuitdelinfo.app.users.service;

import com.nuitdelinfo.app.model.Group;
import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.users.repository.UserRepository;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public void connection(User user) {
        return;
    }

    @Override
    public void deconnection(User user) {
        return;
    }

    @Override
    public void addFriend(User friend, User user) {
        user.getFriends().put(friend.getName(), friend);
    }

    @Override
    public void deleteFriend(User user,String friendName) {
        user.getFriends().remove(friendName);

    }

    @Override
    public void modifyName(User user,String name) {
        user.setName(name);
    }

    @Override
    public void modifyLastName(User user,String lastName) {
        user.setLastName(lastName);
    }

    @Override
    public void modifyPseudo(User user,String pseudo) {
        user.setPseudo(pseudo);
    }

    @Override
    public void modifyEmail(User user,String email) {
        user.setEmail(email);
    }

    @Override
    public void addGroup(User user,Group group) {
        user.getGroups().add(group);

    }

    @Override
    public void deleteGroup(User user,Group group) {
        user.getGroups().remove(group);

    }
}