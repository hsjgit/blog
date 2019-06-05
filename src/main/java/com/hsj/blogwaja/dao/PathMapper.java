package com.hsj.blogwaja.dao;

import com.hsj.blogwaja.entity.Path;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author waja
 */
@Component
public interface PathMapper {
    /**
     * 保存
     * @param path
     */
    void save(Path path);

    /**
     * 查询单个博客文章
     * @param blogName blog的主键blog_id
     * @param blogTitle blog的title
     * @return 查询结果集
     */
    Path select(@Param("blogName") String blogName, @Param("blogTitle") String blogTitle);
}
