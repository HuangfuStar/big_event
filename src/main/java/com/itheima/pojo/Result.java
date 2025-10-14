package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    static public Result success() {
        return new Result(0, "操作成功", null);
    }
    static public Result success(Object data) {
        return new Result(0, "操作成功", data);
    }

    static public Result error(String msg) {
        return new Result(1, msg, null);
    }

}
