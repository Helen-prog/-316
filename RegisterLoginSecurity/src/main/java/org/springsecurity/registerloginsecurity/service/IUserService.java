package org.springsecurity.registerloginsecurity.service;

import org.springsecurity.registerloginsecurity.entity.User;

public interface IUserService {
    public User saveUser(User user);
    public void removeSessionMessage();
}
