package com.hsj.blogwaja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 黄仕杰
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/1").setViewName("admin/blog");//博客后台的总管理页面
        registry.addViewController("/2").setViewName("admin/category");//博客后台的分类管理页面
        registry.addViewController("/3").setViewName("admin/comment");//博客后台的评论管理页面
        registry.addViewController("/4").setViewName("admin/configuration");//博客网站的站点信息
        registry.addViewController("/5").setViewName("admin/edit");//写博客的页面
        registry.addViewController("/6").setViewName("admin/footer");//这个暂时还不晓得，可能是有些数据没得导致的页面错误
        registry.addViewController("/7").setViewName("admin/header");//这个是博客的头部，就是有些重复出现的摘取出来
        registry.addViewController("/8").setViewName("admin/index");//博客的管理首页
        registry.addViewController("/9").setViewName("admin/link");//友情连接，可以添加修改推荐的连接
        registry.addViewController("/10").setViewName("admin/login");//登录
        registry.addViewController("/11").setViewName("admin/profile");//信息修改页面
        registry.addViewController("/12").setViewName("admin/sidebar");//这个和head差不多，边栏
        registry.addViewController("/13").setViewName("admin/tag");//标签管理，博客的标签
        registry.addViewController("/14").setViewName("admin/test");//图片上传
        /**************************************************************************************************************
         * 到这里是一个文件夹的查看结束
         * 接下来看blog文件夹
         ************************************************************************************************************/
        registry.addViewController("/a1").setViewName("blog/amaze/blog-list");
        registry.addViewController("/a2").setViewName("blog/amaze/detail");
        registry.addViewController("/a3").setViewName("blog/amaze/footer");
        registry.addViewController("/a4").setViewName("blog/amaze/header");
        registry.addViewController("/a5").setViewName("blog/amaze/index");
        registry.addViewController("/a6").setViewName("blog/amaze/keyword-list");
        registry.addViewController("/a7").setViewName("blog/amaze/link");
        registry.addViewController("/a8").setViewName("blog/amaze/list");
        registry.addViewController("/a9").setViewName("blog/amaze/side");//文章搜索
        /**************************************************************************************************************
         *
         *
         ************************************************************************************************************/
        registry.addViewController("/d1").setViewName("blog/default/detail");
        registry.addViewController("/d2").setViewName("blog/default/footer");
        registry.addViewController("/d3").setViewName("blog/default/header");
        registry.addViewController("/d4").setViewName("blog/default/index");
        registry.addViewController("/d5").setViewName("blog/default/link");
        registry.addViewController("/d6").setViewName("blog/default/list");
        /**************************************************************************************************************
         *
         *
         ************************************************************************************************************/
        registry.addViewController("/y1").setViewName("blog/yummy-jekyll/category");
        registry.addViewController("/y2").setViewName("blog/yummy-jekyll/detail");
        registry.addViewController("/y3").setViewName("blog/yummy-jekyll/footer");
        registry.addViewController("/y4").setViewName("blog/yummy-jekyll/header");
        registry.addViewController("/y5").setViewName("blog/yummy-jekyll/index");
        registry.addViewController("/y6").setViewName("blog/yummy-jekyll/link");
        registry.addViewController("/y7").setViewName("blog/yummy-jekyll/list");
    }
}
