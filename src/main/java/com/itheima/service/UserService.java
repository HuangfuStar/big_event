package com.itheima.service;

import com.itheima.pojo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUsername(String username);

    void register(User user);

    void deleteByUsername(String  username);

    void updateUserByUsername(User user);

    void updateAvatarByUsername(User user);

    void updatePasswordByUsername(User user);
}
