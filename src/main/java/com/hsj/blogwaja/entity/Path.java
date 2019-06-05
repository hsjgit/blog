package com.hsj.blogwaja.entity;

import lombok.Data;
/**
 * @author waja
 */
@Data
public class Path {
    private int id;
    private String blogPath;
    /**
     * blogName是tb_blog的主键，也就是blog_id
     */
    private String blogName;
    private String blogTitle;
    public Path(Blog blog) {
        this.blogName = blog.getBlogId() + "";
        this.blogTitle = blog.getBlogTitle();
    }

    @Override
    public boolean equals(Object object) {
        Path path = (Path) object;
        return this.id ==path.id  &&this.blogName.equals(path.blogName)&&
                this.blogPath.equals(this.blogPath)&&
                this.blogTitle.equals(path.blogTitle);
    }
    @Override
    public int hashCode() {
        return this.blogTitle.hashCode()+this.blogPath.hashCode()+
                this.blogName.hashCode()+this.id*32;
    }
}
