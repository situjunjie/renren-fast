package io.renren.modules.gym.course.controller.req;

import io.renren.common.dto.TransferDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @className: CourseCoachRelationUpdateRequest
 * @description:
 * @author: situjunjie
 * @date: 2022/12/1
 **/
@Data
public class CourseCoachRelationUpdateRequest implements Serializable {
    private static final long serialVersionUID = 6775621777687338055L;

    private Long courseId;

    private List<Long> coachIds;
}
