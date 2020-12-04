package com.nuitdelinfo.app.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nuitdelinfo.app.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByName(String name);
}