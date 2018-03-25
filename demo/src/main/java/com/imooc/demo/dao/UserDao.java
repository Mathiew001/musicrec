package com.imooc.demo.dao;

import com.imooc.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    void insertUser(User user);
    User queryByUserId(String userId);
}
