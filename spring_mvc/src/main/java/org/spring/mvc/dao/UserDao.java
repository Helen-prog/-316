package org.spring.mvc.dao;

import org.spring.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveUser(User user) {
        String sql = "insert into user(name, email, password) values(?,?,?)";
        int i = jdbcTemplate.update(sql, user.getFullName(), user.getEmail(), user.getPassword());
        return i;
    }
}
