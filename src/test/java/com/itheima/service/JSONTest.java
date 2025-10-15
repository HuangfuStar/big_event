package com.itheima.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JSONTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testObjectMapper() {
        String json = "{\"username\":\"admin\",\"password\":\"123456\"}";
        try {
            User user = objectMapper.readValue(json, User.class);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
