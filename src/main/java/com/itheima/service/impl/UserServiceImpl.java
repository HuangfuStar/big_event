package com.itheima.service.impl;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.entity.User;
import com.itheima.service.UserService;
import com.itheima.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void register(User user) {
        user.setPassword(Md5Util.getMD5String(user.getPassword()));
        userMapper.register(user);
    }

    @Override
    public void deleteByUsername(String username) {
        userMapper.deleteByUsername(username);
    }

    @Override
    public void updateUserByUsername(User user) {
        userMapper.updateUserByUsername(user);
    }

    @Override
    public void updateAvatarByUsername(User user) {
        userMapper.updateAvatarByUsername(user);
    }

    @Override
    public void updatePasswordByUsername(User user) {
        userMapper.updatePasswordByUsername(user);
    }


}
