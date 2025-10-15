package com.itheima.service;

import com.itheima.pojo.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        User user = userService.findByUsername("admin");
        Assertions.assertNotNull(user);

        user = userService.findByUsername("adminfdsafdasfdasfdddsfuiewhtg");
        Assertions.assertNull(user);
    }
}
