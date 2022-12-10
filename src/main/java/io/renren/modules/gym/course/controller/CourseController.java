package io.renren.modules.gym.course.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.gym.course.entity.CourseEntity;
import io.renren.modules.gym.course.service.CourseService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 课程表
 *
 * @author java
 * @email java
 * @date 2022-11-29 23:39:45
 */
@RestController
@RequestMapping("course/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("course:course:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("course:course:info")
    public R info(@PathVariable("id") Long id){
		CourseEntity course = courseService.getById(id);

        return R.ok().put("course", course);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("course:course:save")
    public R save(@RequestBody CourseEntity course){
		courseService.save(course);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("course:course:update")
    public R update(@RequestBody CourseEntity course){
		courseService.updateById(course);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("course:course:delete")
    public R delete(@RequestBody Long[] ids){
		courseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 获取全部
     */
    @RequestMapping("/listAll")
    public R listAll(){
        return R.ok().data(courseService.list());
    }


}
