package io.renren.modules.gym.equipment.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.gym.equipment.entity.EquipmentEntity;
import io.renren.modules.gym.equipment.service.EquipmentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 器材表
 *
 * @author java
 * @email java
 * @date 2022-12-02 22:07:41
 */
@RestController
@RequestMapping("equipment/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("equipment:equipment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = equipmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("equipment:equipment:info")
    public R info(@PathVariable("id") Long id){
		EquipmentEntity equipment = equipmentService.getById(id);

        return R.ok().put("equipment", equipment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("equipment:equipment:save")
    public R save(@RequestBody EquipmentEntity equipment){
		equipmentService.save(equipment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("equipment:equipment:update")
    public R update(@RequestBody EquipmentEntity equipment){
		equipmentService.updateById(equipment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("equipment:equipment:delete")
    public R delete(@RequestBody Long[] ids){
		equipmentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
