package com.hsj.blogwaja.service;

import com.hsj.blogwaja.controller.vo.BlogDetailVO;
import com.hsj.blogwaja.controller.vo.BlogListVO;
import com.hsj.blogwaja.entity.Blog;
import com.hsj.blogwaja.util.PageQueryUtil;
import com.hsj.blogwaja.util.PageResult;

import java.util.List;

/**
 * @author waja
 */
public interface BlogService {
    /**
     * dads
     * @param blog dsd
     * @return dsds
     */
    String saveBlog(Blog blog);

    /**
     * dasdas
     * @param pageUtil dsa
     * @return dsad
     */
    PageResult getBlogsPage(PageQueryUtil pageUtil);

    /**
     * dsad
     * @param ids ds
     * @return dsad
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * dsda
     * @return dsad
     */
    int getTotalBlogs();

    /**
     * 根据id获取详情
     *
     * @param blogId dsad
     * @return dsad
     */
    Blog getBlogById(Long blogId);

    /**
     * 后台修改
     *
     * @param blog dsa
     * @return dsad
     */
    String updateBlog(Blog blog);

    /**
     * 获取首页文章列表
     *
     * @param page dsa
     * @return dsa
     */
    PageResult getBlogsForIndexPage(int page);

    /**
     * 首页侧边栏数据列表
     * 0-最热 1-最新
     *
     * @param type dsa
     * @return dsa
     */
    List<BlogListVO> getBlogListForIndexPage(int type);

    /**
     * 文章详情
     *
     * @param blogId dsa
     * @return dsa
     */
    BlogDetailVO getBlogDetail(Long blogId);

    /**
     * 根据标签获取文章列表
     *
     * @param tagName ds
     * @param page dsd
     * @return ds
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 根据分类获取文章列表
     *
     * @param categoryId dsa
     * @param page ds
     * @return ds
     */
    PageResult getBlogsPageByCategory(String categoryId, int page);

    /**
     * 根据搜索获取文章列表
     *
     * @param keyword ds
     * @param page sad
     * @return dsa
     */
    PageResult getBlogsPageBySearch(String keyword, int page);

    /**
     * dsa
     * @param subUrl ds
     * @return ds
     */
    BlogDetailVO getBlogDetailBySubUrl(String subUrl);
}
