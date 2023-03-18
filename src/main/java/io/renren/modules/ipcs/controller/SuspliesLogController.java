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

import io.renren.modules.ipcs.entity.SuspliesLogEntity;
import io.renren.modules.ipcs.service.SuspliesLogService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 入出库记录
 *
 * @author 
 * @email 
 * @date 2023-03-01 13:49:05
 */
@RestController
@RequestMapping("ipcs/susplieslog")
public class SuspliesLogController {
    @Autowired
    private SuspliesLogService suspliesLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:susplieslog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suspliesLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:susplieslog:info")
    public R info(@PathVariable("id") Long id){
		SuspliesLogEntity suspliesLog = suspliesLogService.getById(id);

        return R.ok().put("suspliesLog", suspliesLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:susplieslog:save")
    public R save(@RequestBody SuspliesLogEntity suspliesLog){
		suspliesLogService.save(suspliesLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:susplieslog:update")
    public R update(@RequestBody SuspliesLogEntity suspliesLog){
		suspliesLogService.updateById(suspliesLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:susplieslog:delete")
    public R delete(@RequestBody Long[] ids){
		suspliesLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
