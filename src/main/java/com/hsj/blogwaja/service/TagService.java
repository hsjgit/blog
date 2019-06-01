package com.hsj.blogwaja.service;

import com.hsj.blogwaja.entity.BlogTagCount;
import com.hsj.blogwaja.util.PageQueryUtil;
import com.hsj.blogwaja.util.PageResult;

import java.util.List;

public interface TagService {

    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    int getTotalTags();

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
