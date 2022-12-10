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

import io.renren.modules.gym.coach.entity.CoachEntity;
import io.renren.modules.gym.coach.service.CoachService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 教练表
 *
 * @author java
 * @email java
 * @date 2022-11-29 18:48:46
 */
@RestController
@RequestMapping("coach/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("coach:coach:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coachService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("coach:coach:info")
    public R info(@PathVariable("id") Long id){
		CoachEntity coach = coachService.getById(id);

        return R.ok().put("coach", coach);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("coach:coach:save")
    public R save(@RequestBody CoachEntity coach){
		coachService.save(coach);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("coach:coach:update")
    public R update(@RequestBody CoachEntity coach){
		coachService.updateById(coach);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("coach:coach:delete")
    public R delete(@RequestBody Long[] ids){
		coachService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 获取全部
     */
    @RequestMapping("/listAll")
    public R listAll(){
        return R.ok().data(coachService.list());
    }
}
