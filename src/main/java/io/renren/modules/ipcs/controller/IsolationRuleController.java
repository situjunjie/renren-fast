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

import io.renren.modules.ipcs.entity.IsolationRuleEntity;
import io.renren.modules.ipcs.service.IsolationRuleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 隔离规则
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@RestController
@RequestMapping("ipcs/isolationrule")
public class IsolationRuleController {
    @Autowired
    private IsolationRuleService isolationRuleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:isolationrule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = isolationRuleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:isolationrule:info")
    public R info(@PathVariable("id") Long id){
		IsolationRuleEntity isolationRule = isolationRuleService.getById(id);

        return R.ok().put("isolationRule", isolationRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:isolationrule:save")
    public R save(@RequestBody IsolationRuleEntity isolationRule){
		isolationRuleService.save(isolationRule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:isolationrule:update")
    public R update(@RequestBody IsolationRuleEntity isolationRule){
		isolationRuleService.updateById(isolationRule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:isolationrule:delete")
    public R delete(@RequestBody Long[] ids){
		isolationRuleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
