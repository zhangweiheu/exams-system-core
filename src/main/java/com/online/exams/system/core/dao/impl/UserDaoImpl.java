package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.UserDao;
import com.online.exams.system.core.mapper.UserMapper;
import com.online.exams.system.core.model.User;
import com.online.exams.system.core.model.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 36kr on 16/1/25.
 */
public class UserDaoImpl implements UserDao{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String name) {
        UserCondition condition = new UserCondition();
        condition.createCriteria().andNameEqualTo(name);
        return userMapper.selectByCondition(condition).get(0);
    }
}
