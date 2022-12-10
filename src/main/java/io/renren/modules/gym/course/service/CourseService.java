package io.renren.modules.gym.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.course.entity.CourseEntity;

import java.util.Map;

/**
 * 课程表
 *
 * @author java
 * @email java
 * @date 2022-11-29 23:39:45
 */
public interface CourseService extends IService<CourseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

