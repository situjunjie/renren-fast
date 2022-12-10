package io.renren.modules.gym.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 课程排班明细
 *
 * @author java
 * @email java
 * @date 2022-12-05 23:02:40
 */
@Data
@TableName("gym_course_detail")
public class CourseDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 课程id
	 */
	private Long courseId;
	/**
	 * 教练id
	 */
	private Long coachId;
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date beginTime;
	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

}
