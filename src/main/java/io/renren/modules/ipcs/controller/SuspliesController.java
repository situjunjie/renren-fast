package io.renren.modules.ipcs.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.ipcs.entity.vo.ReceiveVo;
import io.renren.modules.ipcs.entity.vo.SendVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.ipcs.entity.SuspliesEntity;
import io.renren.modules.ipcs.service.SuspliesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 物资表
 *
 * @author
 * @email
 * @date 2023-02-28 21:01:20
 */
@RestController
@RequestMapping("ipcs/susplies")
public class SuspliesController {
    @Autowired
    private SuspliesService suspliesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:susplies:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suspliesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:susplies:info")
    public R info(@PathVariable("id") Long id){
		SuspliesEntity susplies = suspliesService.getById(id);

        return R.ok().put("susplies", susplies);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:susplies:save")
    public R save(@RequestBody SuspliesEntity susplies){
		suspliesService.save(susplies);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:susplies:update")
    public R update(@RequestBody SuspliesEntity susplies){
		suspliesService.updateById(susplies);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:susplies:delete")
    public R delete(@RequestBody Long[] ids){
		suspliesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @PostMapping("/receive")
    public R receive(@RequestBody ReceiveVo receiveVo){
        suspliesService.receive(receiveVo);
        return R.ok();
    }

    @PostMapping("/send")
    public R send(@RequestBody SendVo sendVo){
        suspliesService.send(sendVo);
        return R.ok();
    }

}
