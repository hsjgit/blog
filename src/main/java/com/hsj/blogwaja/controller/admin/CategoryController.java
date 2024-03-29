package com.hsj.blogwaja.controller.admin;

import com.hsj.blogwaja.service.CategoryService;
import com.hsj.blogwaja.util.PageQueryUtil;
import com.hsj.blogwaja.util.PageResult;
import com.hsj.blogwaja.util.Result;
import com.hsj.blogwaja.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * @author 黄仕杰
 */

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categoryPage(HttpServletRequest request) {
        request.setAttribute("path", "categories");
        return "admin/category";
    }

    /**
     * 分类列表
     */
    @RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        String page = "page";
        String limit = "limit";
        if (StringUtils.isEmpty(params.get(page)) || StringUtils.isEmpty(params.get(limit))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        PageResult p = categoryService.getBlogCategoryPage(pageUtil);
        return ResultGenerator.genSuccessResult(p);
    }

    /**
     * 分类添加
     */
    @RequestMapping(value = "/categories/save")
    @ResponseBody
    public Result save(@RequestParam("categoryName") String categoryName,
                       @RequestParam("categoryIcon") String categoryIcon,HttpServletRequest request) {
        if (StringUtils.isEmpty(categoryName) || StringUtils.isEmpty(categoryIcon)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (categoryService.saveCategory(categoryName, categoryIcon)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }


    /**
     * 分类修改
     */
    @RequestMapping(value = "/categories/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("categoryId") Integer categoryId,
                         @RequestParam("categoryName") String categoryName,
                         @RequestParam("categoryIcon") String categoryIcon) {
        if (StringUtils.isEmpty(categoryName) || StringUtils.isEmpty(categoryIcon)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (categoryService.updateCategory(categoryId, categoryName, categoryIcon)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }


    /**
     * 分类删除
     */
    @RequestMapping(value = "/categories/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (categoryService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
