package com.online.exams.system.core.service;

import com.online.exams.system.core.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 16/1/25.
 */

public interface UserService {
    User findUserByName(String name);
    User findUserByUid(Integer uid);
    boolean deleteUserByUid(int uid);
    int saveUser(User user);
}
