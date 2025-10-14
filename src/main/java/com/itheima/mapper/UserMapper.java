package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Delete("delete from user where username = #{username}")
    void deleteByUsername(String username);

    @Insert("insert into user(username, password, create_time, update_time) values(#{username}, #{password}, now(), now())")
    void register(User user);
}
