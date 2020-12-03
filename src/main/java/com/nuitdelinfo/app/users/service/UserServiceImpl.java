package com.nuitdelinfo.app.users.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;

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
    public void addFriend(Optional<User> user, Optional<User> friend) {
        if(user.isPresent() && friend.isPresent())
            user.get().getFriends().put(friend.get().getName(), friend.get());
    }

    @Override
    public void deleteFriend(Optional<User> user,String friendName) {
        if(user.isPresent())
            user.get().getFriends().remove(friendName);

    }

    @Override
    public void modifyName(Optional<User> user,String name) {
        if( user.isPresent())
            user.get().setName(name);
        
    }

    @Override
    public void modifyLastName(Optional<User> user,String lastName) {
        if( user.isPresent() ){
            user.get().setLastName(lastName);
        }
    }

    @Override
    public void modifyPseudo(Optional<User> user,String pseudo) {
        if( user.isPresent() ){
            user.get().setPseudo(pseudo);
        }
    }

    @Override
    public void modifyEmail(Optional<User> user,String email) {
        if( user.isPresent() ){
            user.get().setEmail(email);
        }
    }

    @Override
    public void subscribe(Optional<User> user,Optional<Group> group) {
        user.map(u -> u.getGroups().add(group.get()));

    }
    
    @Override
    public void unsubscribe(Optional<User> user,Long idg) {
        if(user.isPresent()){
            user.get().getGroups().forEach(g -> {
                if(g.getId() == idg)
                    user.get().getGroups().remove(g);
            });
        }
    }

	@Override
	public Optional<User> getByID(Long id) {
		return repository.findById(id);
	}
}