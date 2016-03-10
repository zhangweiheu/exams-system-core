package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.User;
import com.online.exams.system.core.model.UserCondition;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */
public interface UserDao extends AbstractDao{
    List<User> listAllUser(int offset, int size);
    User findUserByName(String name);
    int saveUser(User user);
    int updateUser(User user);
    int CountByProperty(User user);
}
