package org.springsecurity.registerloginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.registerloginsecurity.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}
