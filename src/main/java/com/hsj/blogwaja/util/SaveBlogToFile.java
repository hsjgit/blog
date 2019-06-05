package com.hsj.blogwaja.util;

import com.hsj.blogwaja.entity.Blog;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Scanner;

/**
 * 将前端传来的blog内容保存到文本里去
 * @author waja
 */
@Service
public class SaveBlogToFile {
    private static String PATH = "D:\\wajatext";
    /**
     * 将blog的内容保存到path的目录下去
     * @param blog 保存的博客
     * @throws IOException 读写异常
     */
    public String save(Blog blog) throws IOException {
        File file = new File(PATH);
        if (!file.exists()) {
            file.mkdir();

        }
        String namath = PATH +"\\"+ blog.getBlogTitle()+".txt";
        PrintWriter writer = new PrintWriter(new FileOutputStream(namath), true);
        writer.println(blog.getBlogContent());
        writer.close();
        return namath;
    }

    /**
     * 将保存在path文件里的blog读取出来
     * @param path 读取的路径
     * @return 读取的内容
     * @throws FileNotFoundException 找不到文件异常
     * @throws UnsupportedEncodingException 字节转换异常
     */
    public String getBlogContent(String path) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner in = new Scanner(new FileInputStream(path));
        StringBuilder stringBuilder = new StringBuilder();
        while (in.hasNext()) {
            stringBuilder.append(in.nextLine());
        }
        String charsetName = "UTF-8";
        return new String(stringBuilder.toString().getBytes(charsetName),charsetName);

    }
}
