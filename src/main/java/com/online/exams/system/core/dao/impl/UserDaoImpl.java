package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.UserDao;
import com.online.exams.system.core.mapper.UserMapper;
import com.online.exams.system.core.model.User;
import com.online.exams.system.core.model.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangwei on 16/1/25.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String name) {
        UserCondition condition = new UserCondition();
        condition.createCriteria().andUsernameEqualTo(name);
        List<User> userList = userMapper.selectByCondition(condition);
        return userList.size() > 0 ? userList.get(0) : null;
    }

    @Override
    public Object findById(int uid) {
        return userMapper.selectById(uid);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public int deleteById(int uid) {
        return userMapper.deleteById(uid);
    }
}
