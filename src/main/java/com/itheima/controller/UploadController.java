package com.itheima.controller;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile[] file) {
        return Result.success();
    }
}
