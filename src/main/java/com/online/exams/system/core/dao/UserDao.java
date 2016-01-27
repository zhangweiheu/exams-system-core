package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 36kr on 16/1/25.
 */
@Repository
public interface UserDao {
    User findUserByName(String name);
}
