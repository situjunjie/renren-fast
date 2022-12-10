package io.renren.modules.ipcs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ipcs.entity.AreaEntity;

import java.util.Map;

/**
 * 区域表
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
public interface AreaService extends IService<AreaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

