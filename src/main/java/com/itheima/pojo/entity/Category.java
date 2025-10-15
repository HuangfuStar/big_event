package com.itheima.pojo.entity;

import com.itheima.pojo.BaseEntity;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    @NotNull(groups = update.class)
    @Positive(groups = update.class)
    Integer id;
    @NotBlank
    @Size(min = 1, max = 32)
    String categoryName;
    @NotBlank
    @Size(min = 1, max = 32)
    String categoryAlias;

    public interface update extends Default {}
}
