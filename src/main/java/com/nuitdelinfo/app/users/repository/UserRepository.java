package com.nuitdelinfo.app.users.repository;

import com.nuitdelinfo.app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
    
}
