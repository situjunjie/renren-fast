package io.renren.modules.gym.coach.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CoachArrangeVo implements Serializable {

    private String coachName;

    private String relationType;

    private String relationName;

    private Date beginTime;

    private Date endTime;

    private String status;

}
