package io.renren.modules.gym.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.course.entity.CourseDetailEntity;

import java.util.Map;

/**
 * 课程排班明细
 *
 * @author java
 * @email java
 * @date 2022-12-05 23:02:40
 */
public interface CourseDetailService extends IService<CourseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

