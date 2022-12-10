package io.renren.modules.gym.course.dao;

import io.renren.modules.gym.course.entity.CourseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程表
 * 
 * @author java
 * @email java
 * @date 2022-11-29 23:39:45
 */
@Mapper
public interface CourseDao extends BaseMapper<CourseEntity> {
	
}
