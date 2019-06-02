package com.hsj.blogwaja.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author waja
 */
@Data
public class BlogTagRelation {
    private Long relationId;

    private Long blogId;

    private Integer tagId;

    private Date createTime;
}