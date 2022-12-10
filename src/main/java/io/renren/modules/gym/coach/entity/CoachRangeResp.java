package io.renren.modules.gym.coach.entity;

import lombok.Data;

/**
 * @className: CoachRangeResp
 * @description:
 * @author: situjunjie
 * @date: 2022/12/7
 **/
@Data
public class CoachRangeResp {

    private Long id;

    private String coachName;

    private Integer score;

    private String  content;

    private String createBy;
}
