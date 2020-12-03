package com.nuitdelinfo.app.users.service;

import java.util.Optional;
import com.nuitdelinfo.app.model.Group;
import com.nuitdelinfo.app.model.User;

public interface UserService {

    void connection(User user);
    void deconnection(User user);

    void addFriend(Optional<User> user, Optional<User> friend);
    void deleteFriend(Optional<User> user,String friendName);

    void modifyName(Optional<User> user,String name);
    void modifyLastName(Optional<User> user,String lastName);
    void modifyPseudo(Optional<User> user,String pseudo);
    void modifyEmail(Optional<User> user,String email);

    void subscribe(Optional<User> user,Optional<Group> group);
    void unsubscribe(Optional<User> user,Long idg);
	Optional<User> getByID(Long id);
}
