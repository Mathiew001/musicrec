package com.imooc.demo.service.impl;

import com.imooc.demo.dao.UserDao;
import com.imooc.demo.entity.User;
import com.imooc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getByUserId(String userId) {
        return userDao.queryByUserId(userId);
    }
}
