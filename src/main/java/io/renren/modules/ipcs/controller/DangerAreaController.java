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

import io.renren.modules.ipcs.entity.DangerAreaEntity;
import io.renren.modules.ipcs.service.DangerAreaService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 区域风险表
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@RestController
@RequestMapping("ipcs/dangerarea")
public class DangerAreaController {
    @Autowired
    private DangerAreaService dangerAreaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:dangerarea:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dangerAreaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:dangerarea:info")
    public R info(@PathVariable("id") Long id){
		DangerAreaEntity dangerArea = dangerAreaService.getById(id);

        return R.ok().put("dangerArea", dangerArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:dangerarea:save")
    public R save(@RequestBody DangerAreaEntity dangerArea){
		dangerAreaService.save(dangerArea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:dangerarea:update")
    public R update(@RequestBody DangerAreaEntity dangerArea){
		dangerAreaService.updateById(dangerArea);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:dangerarea:delete")
    public R delete(@RequestBody Long[] ids){
		dangerAreaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
