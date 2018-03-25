package com.imooc.demo.service;

import com.imooc.demo.entity.User;

public interface UserService {
    void addUser(User user);
    User getByUserId(String userId);
}
