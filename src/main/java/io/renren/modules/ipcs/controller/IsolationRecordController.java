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

import io.renren.modules.ipcs.entity.IsolationRecordEntity;
import io.renren.modules.ipcs.service.IsolationRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 隔离记录
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@RestController
@RequestMapping("ipcs/isolationrecord")
public class IsolationRecordController {
    @Autowired
    private IsolationRecordService isolationRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:isolationrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = isolationRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:isolationrecord:info")
    public R info(@PathVariable("id") Long id){
		IsolationRecordEntity isolationRecord = isolationRecordService.getById(id);

        return R.ok().put("isolationRecord", isolationRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:isolationrecord:save")
    public R save(@RequestBody IsolationRecordEntity isolationRecord){
		isolationRecordService.save(isolationRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:isolationrecord:update")
    public R update(@RequestBody IsolationRecordEntity isolationRecord){
		isolationRecordService.updateById(isolationRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:isolationrecord:delete")
    public R delete(@RequestBody Long[] ids){
		isolationRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }



}
