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
    public List<User> listAllUser(int offset, int size) {
        UserCondition condition = new UserCondition();
        condition.setLimitOffset(offset);
        condition.setLimitSize(size);
        return userMapper.selectByCondition(condition);
    }

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

    @Override
    public int saveUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByIdSelective(user);
    }

    @Override
    public int CountByProperty(User user) {
        UserCondition condition= new UserCondition();
        UserCondition.Criteria criteria = condition.createCriteria();
        if(null != user && null != user.getIsAdmin()){
            criteria.andIsAdminEqualTo(user.getIsAdmin());
        }
        if(null != user && null != user.getEmail()){
            criteria.andEmailEqualTo(user.getEmail());
        }
        if(null != user && null != user.getUsername()){
            criteria.andUsernameEqualTo(user.getUsername());
        }
        return userMapper.countByCondition(condition);
    }
}
