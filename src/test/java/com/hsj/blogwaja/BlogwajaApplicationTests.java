package com.hsj.blogwaja;

import com.hsj.blogwaja.dao.AdminUserMapper;
import com.hsj.blogwaja.entity.AdminUser;
import com.hsj.blogwaja.service.AdminUserService;
import com.hsj.blogwaja.service.impl.AdminUserServiceImpl;
import com.hsj.blogwaja.util.MD5Util;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogwajaApplicationTests {
    @Autowired
    private AdminUserServiceImpl adminUserService;
    @Test
    public void contextLoads() {
        System.out.println(adminUserService.getUserDetailById(1));

    }

}
