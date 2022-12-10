package io.renren.modules.gym.coach.dao;

import io.renren.modules.gym.coach.entity.CoachEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 教练表
 * 
 * @author java
 * @email java
 * @date 2022-11-29 18:48:46
 */
@Mapper
public interface CoachDao extends BaseMapper<CoachEntity> {
	
}
