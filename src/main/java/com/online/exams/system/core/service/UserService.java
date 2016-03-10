package com.online.exams.system.core.service;

import com.online.exams.system.core.model.User;

import java.util.List;

/**
 * Created by zhangwei on 16/1/25.
 */

public interface UserService {
    int getTotalCount();
    User findUserByName(String name);
    User findUserByUid(Integer uid);
    boolean deleteUserByUid(int uid);
    int saveUser(User user);
    int updateUser(User user);
    List<User> listAllUser(int offset, int size);
}
