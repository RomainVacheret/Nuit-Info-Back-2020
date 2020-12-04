package com.nuitdelinfo.app.groups.repository;

import com.nuitdelinfo.app.model.UGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<UGroup, Long> {
    User findByName(String name);
}