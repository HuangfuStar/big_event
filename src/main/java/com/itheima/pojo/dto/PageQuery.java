package com.itheima.pojo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery {
    @NotNull
    @Positive
    private Integer pageNum;
    @NotNull
    @Positive
    private Integer pageSize;
}
