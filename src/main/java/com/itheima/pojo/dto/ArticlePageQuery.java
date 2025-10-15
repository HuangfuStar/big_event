package com.itheima.pojo.dto;

import com.itheima.validation.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePageQuery extends PageQuery {
    private String title;
    private Integer categoryId;
    @State
    private String state;
}
