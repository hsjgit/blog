package com.hsj.blogwaja.service;

import com.hsj.blogwaja.entity.Blog;
import com.hsj.blogwaja.entity.Path;

/**
 * blog查询,配合将上传的blog存储到服务器文件里
 * @author waja
 */
public interface PathService {
    /**
     *  保存blog的存储路径
     * @param blog 封装了blog的标题，内容，等信息
     */
    void save(Blog blog);

    /**
     * 查询单条数据
     * @param blog 封装了blog的标题，内容，等信息
     * @return
     */
    Path select(Blog blog);
}
