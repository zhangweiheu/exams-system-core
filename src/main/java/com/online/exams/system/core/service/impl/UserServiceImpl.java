package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.UserDao;
import com.online.exams.system.core.model.User;
import com.online.exams.system.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 16/1/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Boolean login() {
        return false;
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }
}
