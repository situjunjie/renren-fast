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

import io.renren.modules.gym.coach.entity.CoachArrangeEntity;
import io.renren.modules.gym.coach.service.CoachArrangeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 教练排班表
 *
 * @author 
 * @email 
 * @date 2023-03-18 15:12:58
 */
@RestController
@RequestMapping("coach/coacharrange")
public class CoachArrangeController {
    @Autowired
    private CoachArrangeService coachArrangeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("coach:coacharrange:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coachArrangeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("coach:coacharrange:info")
    public R info(@PathVariable("id") Long id){
		CoachArrangeEntity coachArrange = coachArrangeService.getById(id);

        return R.ok().put("coachArrange", coachArrange);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("coach:coacharrange:save")
    public R save(@RequestBody CoachArrangeEntity coachArrange){
		coachArrangeService.save(coachArrange);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("coach:coacharrange:update")
    public R update(@RequestBody CoachArrangeEntity coachArrange){
		coachArrangeService.updateById(coachArrange);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("coach:coacharrange:delete")
    public R delete(@RequestBody Long[] ids){
		coachArrangeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
