package io.renren.modules.gym.course.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.gym.course.entity.CourseDetailEntity;
import io.renren.modules.gym.course.service.CourseDetailService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 课程排班明细
 *
 * @author java
 * @email java
 * @date 2022-12-05 23:02:40
 */
@RestController
@RequestMapping("course/coursedetail")
public class CourseDetailController {
    @Autowired
    private CourseDetailService courseDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("course:coursedetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("course:coursedetail:info")
    public R info(@PathVariable("id") Long id){
		CourseDetailEntity courseDetail = courseDetailService.getById(id);

        return R.ok().put("courseDetail", courseDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("course:coursedetail:save")
    public R save(@RequestBody CourseDetailEntity courseDetail){
		courseDetailService.save(courseDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("course:coursedetail:update")
    public R update(@RequestBody CourseDetailEntity courseDetail){
		courseDetailService.updateById(courseDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("course:coursedetail:delete")
    public R delete(@RequestBody Long[] ids){
		courseDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
