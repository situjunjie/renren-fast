package io.renren.modules.gym.coach.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.coach.entity.CoachRangeEntity;

import java.util.Map;

/**
 * 教练评分
 *
 * @author java
 * @email java
 * @date 2022-12-07 19:21:36
 */
public interface CoachRangeService extends IService<CoachRangeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

