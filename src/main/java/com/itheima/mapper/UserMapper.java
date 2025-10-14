package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Delete("delete from user where username = #{username}")
    void deleteByUsername(String username);

    @Insert("insert into user(username, password, create_time, update_time) values(#{username}, #{password}, now(), now())")
    void register(User user);

    @Update("update user set nickname = #{nickname}, email = #{email}, update_time = now() where username = #{username}")
    void updateUserByUsername(User user);

    @Update("update user set user_pic = #{user_pic}, update_time = now() where username = #{username}")
    void updateAvatarByUsername(User user);

    @Update("update user set password = #{password}, update_time = now() where username = #{username}")
    void updatePasswordByUsername(User user);
}
