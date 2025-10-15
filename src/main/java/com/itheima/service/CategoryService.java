package com.itheima.service;

import com.itheima.pojo.entity.Category;
import jakarta.validation.Valid;

public interface CategoryService {
    void insert(@Valid Category category);
}
