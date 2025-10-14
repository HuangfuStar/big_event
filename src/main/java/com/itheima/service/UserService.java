package com.itheima.service;

import com.itheima.pojo.User;
import jakarta.validation.constraints.Pattern;
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
