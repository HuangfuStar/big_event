package com.itheima.controller;

import com.itheima.mapper.CategoryMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Result;
import com.itheima.pojo.entity.Category;
import com.itheima.pojo.entity.User;
import com.itheima.service.CategoryService;
import com.itheima.service.UserService;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@Validated
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public Result add(@RequestBody @Validated Category category) {
        String userName = ThreadLocalUtil.get();
        User user = userMapper.findByUsername(userName);
        category.setCreateUser(user.getId());
        categoryMapper.insert(category);

        return Result.success();
    }

    @GetMapping
    public Result list() {
        return Result.success(categoryMapper.selectAll());
    }

    @GetMapping("/detail")
    public Result detail(@NotNull @Positive Integer id) {
        return Result.success(categoryMapper.selectById(id));
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Category.update.class) Category category) {
        String userName = ThreadLocalUtil.get();
        User user = userMapper.findByUsername(userName);
        category.setUpdateUser(user.getId());
        categoryMapper.updateById(category);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@NotNull @Positive Integer id) {
        categoryMapper.deleteById(id);
        return Result.success();
    }

}
