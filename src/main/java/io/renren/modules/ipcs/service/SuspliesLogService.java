package io.renren.modules.ipcs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ipcs.entity.SuspliesLogEntity;

import java.util.Map;

/**
 * 入出库记录
 *
 * @author 
 * @email 
 * @date 2023-03-01 13:49:05
 */
public interface SuspliesLogService extends IService<SuspliesLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

