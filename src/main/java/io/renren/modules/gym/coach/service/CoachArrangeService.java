package io.renren.modules.gym.coach.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.coach.entity.CoachArrangeEntity;

import java.util.Map;

/**
 * 教练排班表
 *
 * @author 
 * @email 
 * @date 2023-03-18 15:12:58
 */
public interface CoachArrangeService extends IService<CoachArrangeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

