package io.renren.modules.gym.coach.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.coach.entity.CoachEntity;

import java.util.Map;

/**
 * 教练表
 *
 * @author java
 * @email java
 * @date 2022-11-29 18:48:46
 */
public interface CoachService extends IService<CoachEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

