package com.nuitdelinfo.app.groups.repository;

import java.util.Optional;

import com.nuitdelinfo.app.model.UGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GroupRepository extends JpaRepository<UGroup, Long> {
    Optional<UGroup> findByName(String name);
}