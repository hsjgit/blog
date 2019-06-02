package com.hsj.blogwaja.dao;

import com.hsj.blogwaja.entity.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 管理员控制页面
 * @author 黄仕杰
 */
@Component
public interface AdminUserMapper {
    /**
     * 管理员的添加操作
     * @param record 管理员对象
     * @return
     */
    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    /**
     * 登陆方法
     *
     * @param userName
     * @param password
     * @return
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}