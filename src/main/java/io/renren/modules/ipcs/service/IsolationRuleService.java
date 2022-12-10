package io.renren.modules.ipcs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ipcs.entity.IsolationRuleEntity;

import java.util.Map;

/**
 * 隔离规则
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
public interface IsolationRuleService extends IService<IsolationRuleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

