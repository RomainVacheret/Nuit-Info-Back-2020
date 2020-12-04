package com.nuitdelinfo.app.users.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;

import com.nuitdelinfo.app.model.Comment;
import com.nuitdelinfo.app.model.Post;
import com.nuitdelinfo.app.model.UGroup;
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
    public void addFriend(Optional<User> user, Optional<User> friend) {
        if (user.isPresent() && friend.isPresent())
            user.get().getFriends().put(friend.get().getName(), friend.get());
    }

    @Override
    public void deleteFriend(Optional<User> user, String friendName) {
        if (user.isPresent())
            user.get().getFriends().remove(friendName);

    }

    @Override
    public void modifyName(Optional<User> user, String name) {
        if (user.isPresent())
            user.get().setName(name);

    }

    @Override
    public void modifyLastName(Optional<User> user, String lastName) {
        if (user.isPresent()) {
            user.get().setLastName(lastName);
        }
    }

    @Override
    public void modifyPseudo(Optional<User> user, String pseudo) {
        if (user.isPresent()) {
            user.get().setPseudo(pseudo);
        }
    }

    @Override
    public void modifyEmail(Optional<User> user, String email) {
        if (user.isPresent()) {
            user.get().setEmail(email);
        }
    }

    @Override
    public void subscribe(Optional<User> user, Optional<UGroup> group) {
        user.map(u -> u.getGroups().add(group.get()));

    }

    @Override
    public void unsubscribe(Optional<User> user, Long idg) {
        if (user.isPresent()) {
            user.get().getGroups().forEach(g -> {
                if (g.getId() == idg)
                    user.get().getGroups().remove(g);
            });
        }
    }

    @Override
    public Optional<User> getByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public String displayName(Optional<User> user) {
        if (user.isPresent())
            return user.get().getName();
        return null;
    }

    @Override
    public String displayLastName(Optional<User> user) {
        if (user.isPresent())
            return user.get().getLastName();
        return null;
    }

    @Override
    public String displayPseudo(Optional<User> user) {
        if (user.isPresent())
            return user.get().getPseudo();
        return null;
    }

    @Override
    public String displayEmail(Optional<User> user) {
        if (user.isPresent())
            return user.get().getEmail();
        return null;
    }

    @Override
    public Map<String, User> displayFriends(Optional<User> user) {
        if (user.isPresent())
            return user.get().getFriends();
        return null;
    }

    @Override
    public Set<UGroup> displayGroups(Optional<User> user) {
        Set<UGroup> groups = new HashSet<>();
        if (user.isPresent())
            groups = user.get().getGroups();
        return groups;
    }

    @Override
    public Set<Comment> displayComments(Optional<User> user) {
       Set<Comment> comments = new HashSet<>();
       if(user.isPresent())
            comments = user.get().getComments();
        return comments;
    }

    @Override
    public Set<Post> displayPosts(Optional<User> user) {
       Set<Post> posts = new HashSet<>();
       if(user.isPresent()){
           posts = user.get().getPosts();
       }
       return posts;
    }
}