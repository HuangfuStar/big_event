package com.itheima.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePwdDTO {
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$")
    String oldPwd;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$")
    String newPwd;
}
