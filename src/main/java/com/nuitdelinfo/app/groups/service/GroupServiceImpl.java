

import java.security.acl.Group;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;

import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.groups.repository.GroupRepository;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  
    private GroupRepository repository;


    @Override
    void addUsertoGroup(Optional<UGroup> group, Optional<User> user){
        group.map(group.get().getSubscribers().put(user.get().getName(), user.get()));
    }
    
    @Override
    void deleteUsertoGroup(Optional<UGroup> group, Optional<User> user,String userName){
        if(group.isPresent() && user.isPresent())
            group.get().getSubscribers().remove(userName);
    }

    @Override
    void deleteGroupe(Optional<UGroup> group,String GroupName){
        if(group.isPresent())
            group.get().getSubscribers().remove(GroupName);
    }

    @Override
    void addGroup(Optional<UGroup> group,String GroupName){
        group.map( group.get().getSubscribers().add(GroupName));
    }

    @Override
    void modifyGName(Optional<UGroup> group,String groupName){
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


