package com.itheima.mapper;

import com.itheima.pojo.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) values " +
            "(#{categoryName}, #{categoryAlias}, #{createUser}, NOW(), NOW())")
    void insert(Category category);

    @Select("select * from category;")
    List<Category> selectAll();

    @Select("select * from category where id = #{id};")
    Category selectById(@Positive Integer id);

    @Update("update category set category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = NOW() where id = #{id};")
    void updateById(Category category);

    @Delete("delete from category where id = #{id};")
    void deleteById(@NotNull @Positive Integer id);
}
