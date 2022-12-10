package io.renren.modules.gym.coach.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.modules.gym.coach.entity.CoachRangeResp;
import io.renren.modules.gym.coach.entity.CoachRangeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 教练评分
 *
 * @author java
 * @email java
 * @date 2022-12-07 19:21:36
 */
@Mapper
public interface CoachRangeDao extends BaseMapper<CoachRangeEntity> {

    IPage<CoachRangeResp> pageCoachRange(IPage<CoachRangeResp> page, Map<String, Object> params);
}
