package org.springsecurity.registerloginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.registerloginsecurity.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public Boolean existsByName(String name);
}
