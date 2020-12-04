package com.nuitdelinfo.app.groups.service;

import java.util.Optional;
import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.model.User;

public interface GroupService {
    void addUsertoGroup(Optional<UGroup> group, Optional<User> user);
    void deleteUsertoGroup(Optional<UGroup> group, Optional<User> user,String userName);
    void deleteGroupe(Optional<UGroup> group);
    void modifyGName(Optional<UGroup> group,String name);
    void save(UGroup group);
    Optional<UGroup> getByIDG(Long id);
}
