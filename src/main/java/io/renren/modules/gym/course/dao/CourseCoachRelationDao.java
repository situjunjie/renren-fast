package io.renren.modules.gym.course.dao;

import io.renren.modules.gym.course.entity.CourseCoachRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程教练关联表
 * 
 * @author java
 * @email java
 * @date 2022-11-30 21:58:53
 */
@Mapper
public interface CourseCoachRelationDao extends BaseMapper<CourseCoachRelationEntity> {
	
}
