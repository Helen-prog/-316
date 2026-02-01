package org.springsecurity.registerloginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.registerloginsecurity.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByCategory(String category);
}
