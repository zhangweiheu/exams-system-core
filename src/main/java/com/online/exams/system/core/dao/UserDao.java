package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 36kr on 16/1/25.
 */
public interface UserDao extends AbstractDao{
    User findUserByName(String name);
    int saveUser(User user);
}
