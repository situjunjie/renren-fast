package io.renren.modules.gym.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.dto.TransferDTO;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.course.controller.req.CourseCoachRelationUpdateRequest;
import io.renren.modules.gym.course.entity.CourseCoachRelationEntity;

import java.util.Map;

/**
 * 课程教练关联表
 *
 * @author java
 * @email java
 * @date 2022-11-30 21:58:53
 */
public interface CourseCoachRelationService extends IService<CourseCoachRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    TransferDTO listCoachTransfer(Long courseId);

    void updateCourseCoachRelation(CourseCoachRelationUpdateRequest request);
}

