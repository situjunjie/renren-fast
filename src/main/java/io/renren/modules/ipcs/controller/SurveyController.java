package io.renren.modules.ipcs.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.ipcs.entity.SurveyEntity;
import io.renren.modules.ipcs.service.SurveyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 流调记录
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@RestController
@RequestMapping("ipcs/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:survey:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = surveyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:survey:info")
    public R info(@PathVariable("id") Long id){
		SurveyEntity survey = surveyService.getById(id);

        return R.ok().put("survey", survey);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:survey:save")
    public R save(@RequestBody SurveyEntity survey){
		surveyService.save(survey);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:survey:update")
    public R update(@RequestBody SurveyEntity survey){
		surveyService.updateById(survey);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:survey:delete")
    public R delete(@RequestBody Long[] ids){
		surveyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
