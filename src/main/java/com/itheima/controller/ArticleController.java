package com.itheima.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ArticleMapper;
import com.itheima.mapper.CategoryMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.PageData;
import com.itheima.pojo.Result;
import com.itheima.pojo.dto.ArticlePageQuery;
import com.itheima.pojo.entity.Article;
import com.itheima.pojo.entity.Category;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        Category category = categoryMapper.selectById(article.getCategoryId());
        if (category == null) return Result.error("文章分类不存在");
        String userName = ThreadLocalUtil.get();
        article.setCreateUser(userMapper.findByUsername(userName).getId());
        articleMapper.insert(article);
        return Result.success();
    }

    @GetMapping
    public Result list(@Validated ArticlePageQuery articlePageQuery) {
        PageHelper.startPage(articlePageQuery.getPageNum(), articlePageQuery.getPageSize());
//
        Page<Article> list = (Page<Article>) articleMapper.selectByQuery(articlePageQuery);

        return Result.success(
                new PageData<Article>(list.getTotal(), list.getResult())
        );
    }

    @GetMapping("/detail")
    public Result detail(@NotNull @Positive Integer id) {
        return Result.success(articleMapper.selectById(id));
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Article.Update.class) Article article) {
        Category category = categoryMapper.selectById(article.getCategoryId());
        if (category == null) return Result.error("文章分类不存在");
        String userName = ThreadLocalUtil.get();
        article.setUpdateUser(userMapper.findByUsername(userName).getId());
        articleMapper.updateById(article);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@NotEmpty @RequestParam List<Integer> ids) {
        articleMapper.deleteByIds(ids);
        return Result.success();
    }
}
