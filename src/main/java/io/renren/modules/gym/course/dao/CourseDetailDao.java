package io.renren.modules.gym.course.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.modules.gym.course.entity.CourseDetailResp;
import io.renren.modules.gym.course.entity.CourseDetailEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 课程排班明细
 *
 * @author java
 * @email java
 * @date 2022-12-05 23:02:40
 */
@Mapper
public interface CourseDetailDao extends BaseMapper<CourseDetailEntity> {

    IPage<CourseDetailResp> pageCourseDetail(IPage<CourseDetailResp> page, @Param("params") Map<String,Object> params);

}
