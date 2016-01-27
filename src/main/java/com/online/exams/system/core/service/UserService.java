package com.online.exams.system.core.service;

import com.online.exams.system.core.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 16/1/25.
 */
@Service
public interface UserService {
    Boolean login();

    User findUserByName(String name);
}
