package com.atguigu.guli.service.edu.controller;


import com.atguigu.guli.common.base.result.R;
import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.vo.TeacherQueryVo;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zsf
 * @since 2019-11-20
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表", notes = "返回所有讲师列表")
    @GetMapping("list")
    public R listAll() {
        List<Teacher> teachers = this.teacherService.list(null);
        return R.ok().data("items", teachers).message("获取讲师列表成功");
    }

    @ApiOperation(value = "根据ID删除讲师", notes = "根据ID删除讲师")
    @DeleteMapping("remove/{id}")
    public R remoceById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable("id") String id) {
        boolean b = this.teacherService.removeById(id);
        return R.ok().message("删除讲师成功");
    }

/*
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        IPage<Teacher> teacherIPage = this.teacherService.page(pageParam, null);
        List<Teacher> records = teacherIPage.getRecords();
        long total = teacherIPage.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }
*/

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQueryVo teacherQueryVo) {

        Page<Teacher> pageParam = new Page<>(page, limit);
        IPage<Teacher> pageModel = teacherService.selectPage(pageParam, teacherQueryVo);
        List<Teacher> records = pageModel.getRecords();
        long total = pageModel.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        this.teacherService.save(teacher);
        return R.ok().message("插入讲师信息成功");
    }

    @ApiOperation(value = "获取讲师")
    @GetMapping("get/{id}")
    public R get(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return R.ok().message("获取讲师信息成功").data("item", teacher);
    }

    @ApiOperation(value = "修改讲师")
    @PutMapping("update")
    public R updateById(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        teacherService.updateById(teacher);
        return R.ok().message("修改讲师信息成功");
    }
}

