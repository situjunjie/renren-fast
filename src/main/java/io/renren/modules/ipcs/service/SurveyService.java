package io.renren.modules.ipcs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ipcs.entity.SurveyEntity;

import java.util.Map;

/**
 * 流调记录
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
public interface SurveyService extends IService<SurveyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

