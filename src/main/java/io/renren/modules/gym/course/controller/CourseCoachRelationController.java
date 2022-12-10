package io.renren.modules.gym.course.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.gym.course.controller.req.CourseCoachRelationUpdateRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.gym.course.entity.CourseCoachRelationEntity;
import io.renren.modules.gym.course.service.CourseCoachRelationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 课程教练关联表
 *
 * @author java
 * @email java
 * @date 2022-11-30 21:58:53
 */
@RestController
@RequestMapping("course/coursecoachrelation")
public class CourseCoachRelationController {
    @Autowired
    private CourseCoachRelationService courseCoachRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("course:coursecoachrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseCoachRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("course:coursecoachrelation:info")
    public R info(@PathVariable("id") Long id){
		CourseCoachRelationEntity courseCoachRelation = courseCoachRelationService.getById(id);

        return R.ok().put("courseCoachRelation", courseCoachRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("course:coursecoachrelation:save")
    public R save(@RequestBody CourseCoachRelationEntity courseCoachRelation){
		courseCoachRelationService.save(courseCoachRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("course:coursecoachrelation:update")
    public R update(@RequestBody CourseCoachRelationEntity courseCoachRelation){
		courseCoachRelationService.updateById(courseCoachRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("course:coursecoachrelation:delete")
    public R delete(@RequestBody Long[] ids){
		courseCoachRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 课程安排教练的穿梭框数据
     */
    @RequestMapping("/transferData")
    public R listCoachTransfer(@RequestBody Long courseId){
        return R.ok().data(courseCoachRelationService.listCoachTransfer(courseId));
    }

    @RequestMapping("/updateBath")
    public R updateBath(@RequestBody CourseCoachRelationUpdateRequest request){
        courseCoachRelationService.updateCourseCoachRelation(request);
        return R.ok();
    }

}
