package com.itheima.mapper;

import com.itheima.pojo.dto.ArticlePageQuery;
import com.itheima.pojo.entity.Article;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, NOW(), NOW())")
    void insert(Article article);

    List<Article> selectByQuery(ArticlePageQuery articlePageQuery);

    @Select("select * from article where id = #{id}")
    Article selectById(@NotNull @Positive Integer id);

    @Update("update article set title = #{title}, content = #{content}, cover_img = #{coverImg}, state = #{state}, category_id = #{categoryId}, update_time = NOW() where id = #{id}")
    void updateById(Article article);

    void deleteByIds(@NotEmpty List<Integer> ids);
}
