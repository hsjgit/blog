package com.hsj.blogwaja.entity;

import lombok.Data;

/**
 * 管理员
 * @author 黄仕杰
 */
@Data
public class AdminUser {
    private Integer adminUserId;

    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private Byte locked;

}