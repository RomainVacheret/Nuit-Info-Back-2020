package com.nuitdelinfo.app.users.service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.nuitdelinfo.app.model.Comment;
import com.nuitdelinfo.app.model.Post;
import com.nuitdelinfo.app.model.UGroup;
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

    void subscribe(Optional<User> user,Optional<UGroup> group);
    void unsubscribe(Optional<User> user,Long idg);

    String displayName(Optional<User> user);
    String displayLastName(Optional<User> user);
    String displayPseudo(Optional<User> user);
    String displayEmail(Optional<User> user);
    Map<String, User> displayFriends(Optional<User> user);
    Set<UGroup> displayGroups(Optional<User> user);
    Set<Comment> displayComments(Optional<User> user);
    Set<Post> displayPosts(Optional<User> user);

	Optional<User> getByID(Long id);
}
