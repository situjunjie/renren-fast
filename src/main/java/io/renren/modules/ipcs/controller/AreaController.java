package io.renren.modules.ipcs.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.dto.TreeNodeDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.ipcs.entity.AreaEntity;
import io.renren.modules.ipcs.service.AreaService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 区域表
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@RestController
@RequestMapping("ipcs/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:area:list")
    public R list(@RequestParam Map<String, Object> params){
        List<TreeNodeDTO> treeNodeDTOS = areaService.listTree(params);

        return R.ok().put("data", treeNodeDTOS);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:area:info")
    public R info(@PathVariable("id") Long id){
		AreaEntity area = areaService.getById(id);

        return R.ok().put("area", area);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:area:save")
    public R save(@RequestBody AreaEntity area){
		areaService.save(area);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:area:update")
    public R update(@RequestBody AreaEntity area){
		areaService.updateById(area);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:area:delete")
    public R delete(@RequestBody Long[] ids){
		areaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @RequestMapping("/updateDangerLevel")
    @RequiresPermissions("ipcs:area:updateDangerLevel")
    public R updateDangerLevel(@RequestBody Map<String,Object> params){
        areaService.updateDangerLevel(params);
        return R.ok();
    }




}
