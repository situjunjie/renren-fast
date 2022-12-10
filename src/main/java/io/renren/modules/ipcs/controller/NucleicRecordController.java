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

import io.renren.modules.ipcs.entity.NucleicRecordEntity;
import io.renren.modules.ipcs.service.NucleicRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 核酸记录
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@RestController
@RequestMapping("ipcs/nucleicrecord")
public class NucleicRecordController {
    @Autowired
    private NucleicRecordService nucleicRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ipcs:nucleicrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nucleicRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ipcs:nucleicrecord:info")
    public R info(@PathVariable("id") Long id){
		NucleicRecordEntity nucleicRecord = nucleicRecordService.getById(id);

        return R.ok().put("nucleicRecord", nucleicRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ipcs:nucleicrecord:save")
    public R save(@RequestBody NucleicRecordEntity nucleicRecord){
		nucleicRecordService.save(nucleicRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ipcs:nucleicrecord:update")
    public R update(@RequestBody NucleicRecordEntity nucleicRecord){
		nucleicRecordService.updateById(nucleicRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ipcs:nucleicrecord:delete")
    public R delete(@RequestBody Long[] ids){
		nucleicRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
