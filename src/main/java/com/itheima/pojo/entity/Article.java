package com.itheima.pojo.entity;

import com.itheima.pojo.BaseEntity;
import com.itheima.validation.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article extends BaseEntity {
    @Positive(groups = {Article.Update.class})
    Integer id;
    @NotBlank
    @Size(min = 1, max = 10)
    private String title;
    @Size(max = 10000)
    private String content;
    @Size(max = 128)
    @URL
    private String coverImg;
    @State
    private String state;
    @Positive
    private Integer categoryId;

    public interface Update extends Default {}
}
