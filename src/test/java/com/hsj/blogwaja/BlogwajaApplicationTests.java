package com.hsj.blogwaja;

import com.hsj.blogwaja.controller.vo.BlogDetailVO;
import com.hsj.blogwaja.controller.vo.BlogListVO;
import com.hsj.blogwaja.dao.AdminUserMapper;
import com.hsj.blogwaja.dao.BlogMapper;
import com.hsj.blogwaja.dao.PathMapper;
import com.hsj.blogwaja.entity.AdminUser;
import com.hsj.blogwaja.entity.Blog;
import com.hsj.blogwaja.entity.Path;
import com.hsj.blogwaja.service.AdminUserService;
import com.hsj.blogwaja.service.BlogService;
import com.hsj.blogwaja.service.PathService;
import com.hsj.blogwaja.service.impl.AdminUserServiceImpl;
import com.hsj.blogwaja.service.impl.BlogServiceImpl;
import com.hsj.blogwaja.util.*;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogwajaApplicationTests {
    @Autowired
    private PathService pathService;
    @Autowired
    private SaveBlogToFile saveBlogToFile;
    @Autowired
    private BlogService blogService;
    @Test
    public void contextLoads() throws IOException {
        Blog blog = new Blog();
        blog.setBlogContent("# 线性表\n" +
                "\n" +
                "##  数组\n" +
                "\n" +
                "记录一下用数组实现的线性结构，并实现增删改查。\n" +
                "\n" +
                "为了能让自己实现的基于数组的线性结构具有普遍性，我们使用的是泛型程序设计\n" +
                "\n" +
                "```java\n" +
                "public class MyString<E> {\n" +
                "    private E[] arry;\n" +
                "    private int size;\n" +
                "```\n" +
                "\n" +
                "E[] arry是一个泛型数组，现在还没有初始化，此时相当于c++中的没有指向任何内存的空指针.和数组是一样的，如果只是定义了数组，没有对数组进行初始化，那么我们在使用数组时机会出现空指针异常。我们在构造方法中进行初始化。\n" +
                "\n" +
                "```java\n" +
                "/**\n" +
                "     * 构建一个指定容量大小的数组\n" +
                "     * @param capacity 指定的容量大小\n" +
                "     */\n" +
                "    public MyString(int capacity) {\n" +
                "        arry = (E[]) new Object[capacity];\n" +
                "        size = 0;\n" +
                "    }\n" +
                "```\n" +
                "\n" +
                "在进行初始化时使用\n" +
                "\n" +
                "```java\n" +
                "arry = (E[]) new Object[capacity];\n" +
                "```\n" +
                "\n" +
                "而不是\n" +
                "\n" +
                "```java\n" +
                "arry =  new E[capacity];\n" +
                "```\n" +
                "\n" +
                "应为java不支持直接对泛型数组初始化为泛型数组，所有我们先初始化为Object类型，在进行强制类型转化为E类型\n" +
                "\n" +
                "### 接下俩就是CURD\n" +
                "\n" +
                "#### 添加操作\n" +
                "\n" +
                "```java\n" +
                "/**\n" +
                "     * 在index位置插入一个新的元素e\n" +
                "     * @param e     添加的元素\n" +
                "     * @param index 插入的位置\n" +
                "     * @throws IllegalAccessException 对应位置不在检索范围异常\n" +
                "     */\n" +
                "    public void add(E e, int index) throws IllegalAccessException {\n" +
                "        if (index < 0 || index > size) {\n" +
                "            throw new IllegalAccessException(\"Add failed. Require index >= 0 and index <= size.\");\n" +
                "        }\n" +
                "        if (index == arry.length) {\n" +
                "            resize(2 * arry.length);\n" +
                "        }\n" +
                "        for (int i=size-1;i>=index;i--) {\n" +
                "            arry[i + 1] = arry[i];\n" +
                "        }\n" +
                "        arry[index] = e;\n" +
                "        size++;\n" +
                "    }\n" +
                "```\n" +
                "\n" +
                "在添加之前先判断数组长度是否大于等于添加的位置,如果大于数组长度则需要对数组进行扩容\n" +
                "\n" +
                "```java\n" +
                "if (index == arry.length) {\n" +
                "            resize(2 * arry.length);\n" +
                "        }\n" +
                "```\n" +
                "\n" +
                "扩容代码,扩容长度为原始长度的2倍\n" +
                "\n" +
                "```java\n" +
                "private void resize(int newCapacity) {\n" +
                "        arry = Arrays.copyOf(arry, newCapacity);\n" +
                "\n" +
                "    }\n" +
                "```\n" +
                "\n" +
                "判断完数组长度后在进行元素的添加操作，元素添加位置原来的元素和之后的元素都要向后移动一个位置\n" +
                "\n" +
                "```java\n" +
                "for (int i=size-1;i>=index;i--) {\n" +
                "            arry[i + 1] = arry[i];\n" +
                "        }\n" +
                "```\n" +
                "\n" +
                "#### 删除操作\n" +
                "\n" +
                "删除操作和添加操作差不多，这里类比直接给代码\n" +
                "\n" +
                "```java\n" +
                "/**\n" +
                "     * 删除数组中index处的元素\n" +
                "     * @param index 需要删除位置的元素\n" +
                "     * @return 返回删除的元素\n" +
                "     * @throws IllegalAccessException 对应位置不在检索范围异常\n" +
                "     */\n" +
                "    public E remove(int index) throws IllegalAccessException {\n" +
                "        if (index < 0 || index > size) {\n" +
                "            throw new IllegalAccessException(\"Add failed. Require index >= 0 and index <= size.\");\n" +
                "        }\n" +
                "        E ret = arry[index];\n" +
                "        for (int i = index + 1; i < size; i++) {\n" +
                "            arry[i - 1] = arry[i];\n" +
                "        }\n" +
                "        size--;\n" +
                "        if (size == arry.length / 4 && 0 != arry.length / 2) {\n" +
                "            resize(arry.length / 2);\n" +
                "        }\n" +
                "        return ret;\n" +
                "    }\n" +
                "```\n" +
                "\n" +
                "#### 查询和修改操作\n" +
                "\n" +
                "```java\n" +
                "/**\n" +
                "     * 把指定位置的元素修改为新的元素\n" +
                "     * @param e 新的元素\n" +
                "     * @param index 修改的位置\n" +
                "     * @return 被修改的元素\n" +
                "     * @throws IllegalAccessException\n" +
                "     */\n" +
                "    public E set(E e,int index) throws IllegalAccessException {\n" +
                "        if (index < 0 || index > size) {\n" +
                "            throw new IllegalAccessException(\"Add failed. Require index >= 0 and index <= size.\");\n" +
                "        }\n" +
                "        arry[index] = e;\n" +
                "        return arry[index];\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 判断数组中是否纯在元素e，如果纯在返回true否则返回false\n" +
                "     * @param e 查找的目标元素\n" +
                "     * @return\n" +
                "     */\n" +
                "    public boolean contains(E e){\n" +
                "        for (int i=0;i<size;i++){\n" +
                "            if (arry[i].equals(e)){\n" +
                "                return true;\n" +
                "            }\n" +
                "        }\n" +
                "        return false;\n" +
                "    }\n" +
                "    /**\n" +
                "     * 在数组中返回检索目元素，如果纯在返回元素索引，否则返回-1\n" +
                "     * @param e 检索的目标元素\n" +
                "     * @return\n" +
                "     */\n" +
                "    public int fount(E e){\n" +
                "        for (int i=0;i<size;i++){\n" +
                "            if (arry[i].equals(e)){\n" +
                "                return i;\n" +
                "            }\n" +
                "        }\n" +
                "        return -1;\n" +
                "    }\n" +
                "```\n" +
                "\n" +
                "基于数组实现的线性结构在查询和修改的时间复杂化度都在O(1)级别的，这里实现的线性结构对应java的ArrayList，所以如果对数组的查询和修改的操作比较多的话，使用ArrayList\n" +
                "\n" +
                "## 栈和队列\n" +
                "\n" +
                "下面使用前面实现的基于数组实现的线性表来实现栈和队列这两种数据结构。\n" +
                "\n" +
                "### 栈\n" +
                "\n" +
                "栈这种数据结构的特点是先进后出（FILO：Fist In Lsat Out），栈这个字在汉语里古人用栈来来形容干草堆，所以用栈来形容FILO这种数据结构是很形象的。\n");
        System.out.println(MarkDownUtil.mdToHtml(saveBlogToFile.getBlogContent("D:\\wajatext\\null.txt")));
    }

}
