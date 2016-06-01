package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.UserDao;
import com.online.exams.system.core.model.User;
import com.online.exams.system.core.mybatis.enums.UserStatusEnum;
import com.online.exams.system.core.mybatis.enums.UserTypeEnum;
import com.online.exams.system.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangwei on 16/1/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAllUser(int offset, int pageSize) {
        return userDao.listAllUser(offset, pageSize);
    }

    @Override
    public int getTotalCount() {
        return userDao.CountByProperty(null);
    }

    @Override
    public int getTotalCommonUser() {
        User user = new User();
        user.setStatus(UserStatusEnum.NORMAL);
        user.setType(UserTypeEnum.COMMON);
        return userDao.CountByProperty(user);
    }

    @Override
    public User findUserByUid(Integer uid) {
        return (User) userDao.findById(uid);
    }

    @Override
    public boolean deleteUserByUid(int uid) {
        return userDao.deleteById(uid) == 1;
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
