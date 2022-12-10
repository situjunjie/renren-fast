package io.renren.modules.gym.coach.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.gym.coach.entity.CoachRangeEntity;
import io.renren.modules.gym.coach.service.CoachRangeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 教练评分
 *
 * @author java
 * @email java
 * @date 2022-12-07 19:21:36
 */
@RestController
@RequestMapping("coach/coachrange")
public class CoachRangeController {
    @Autowired
    private CoachRangeService coachRangeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("coach:coachrange:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coachRangeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("coach:coachrange:info")
    public R info(@PathVariable("id") Long id){
		CoachRangeEntity coachRange = coachRangeService.getById(id);

        return R.ok().put("coachRange", coachRange);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("coach:coachrange:save")
    public R save(@RequestBody CoachRangeEntity coachRange){
		coachRangeService.save(coachRange);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("coach:coachrange:update")
    public R update(@RequestBody CoachRangeEntity coachRange){
		coachRangeService.updateById(coachRange);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("coach:coachrange:delete")
    public R delete(@RequestBody Long[] ids){
		coachRangeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
