package com.hsj.blogwaja.util;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 分页查询参数
 * @author waja
 */
@Data
public class PageQueryUtil extends LinkedHashMap<String, Object> {
    /**
     * page 当前页码
     */
    private int page;

    /**
     * limit 每页条数
     */
    private int limit;

    public PageQueryUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }
}
