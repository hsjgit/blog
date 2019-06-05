package com.hsj.blogwaja;

import com.hsj.blogwaja.controller.vo.BlogDetailVO;
import com.hsj.blogwaja.controller.vo.BlogListVO;
import com.hsj.blogwaja.dao.AdminUserMapper;
import com.hsj.blogwaja.dao.BlogMapper;
import com.hsj.blogwaja.dao.PathMapper;
import com.hsj.blogwaja.entity.AdminUser;
import com.hsj.blogwaja.entity.Blog;
import com.hsj.blogwaja.entity.Path;
import com.hsj.blogwaja.service.AdminUserService;
import com.hsj.blogwaja.service.BlogService;
import com.hsj.blogwaja.service.impl.AdminUserServiceImpl;
import com.hsj.blogwaja.service.impl.BlogServiceImpl;
import com.hsj.blogwaja.util.MD5Util;
import com.hsj.blogwaja.util.PageResult;
import com.hsj.blogwaja.util.TimeUtil;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogwajaApplicationTests {
    @Autowired
    private PathMapper pathMapper;
    @Test
    public void contextLoads(){
        List<Path> list = pathMapper.select("hsj", "hsj");
        for (Path path : list) {
            System.out.println(path);
        }
    }

}
