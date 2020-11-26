package com.overflow.adminportal.user;

import com.overflow.adminportal.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductIntegrationTest {

    @Autowired
    UserService userService;
}
