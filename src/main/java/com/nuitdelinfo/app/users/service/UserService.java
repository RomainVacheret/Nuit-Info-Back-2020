package com.nuitdelinfo.app.users.service;

import com.nuitdelinfo.app.model.Group;
import com.nuitdelinfo.app.model.User;

public interface UserService {

    void connection(User user);
    void deconnection(User user);

    void addFriend(User friend, User user);
    void deleteFriend(User user,String friendName);

    void modifyName(User user,String name);
    void modifyLastName(User user,String lastName);
    void modifyPseudo(User user,String pseudo);
    void modifyEmail(User user,String email);

    void addGroup(User user,Group group);
    void deleteGroup(User user,Group group);
}
