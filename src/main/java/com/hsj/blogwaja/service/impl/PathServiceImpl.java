package com.hsj.blogwaja.service.impl;

import com.hsj.blogwaja.dao.PathMapper;
import com.hsj.blogwaja.entity.Blog;
import com.hsj.blogwaja.entity.Path;
import com.hsj.blogwaja.service.PathService;
import com.hsj.blogwaja.util.SaveBlogToFile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.io.IOException;

/**
 * @author waja
 */
@Component
public class PathServiceImpl implements PathService {
    @Resource
    private SaveBlogToFile saveBlogToFile;
    @Resource
    private PathMapper pathMapper;
    /**
     *  保存blog的存储路径
     * @param blog 封装了blog的标题，内容，等信息
     */
    @Override
    public void save(Blog blog) {
        try {
            Path path = new Path(blog);
            path.setBlogPath(saveBlogToFile.save(blog));
            pathMapper.save(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
