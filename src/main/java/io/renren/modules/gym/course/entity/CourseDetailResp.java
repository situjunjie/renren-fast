package io.renren.modules.gym.course.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @className: CourseDetailResp
 * @description:
 * @author: situjunjie
 * @date: 2022/12/5
 **/
@Data
public class CourseDetailResp implements Serializable {

    private Long id;

    private Long courseId;

    private String courseName;

    private Long coachId;

    private String coachName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private String tips;

    private Integer time;
}
