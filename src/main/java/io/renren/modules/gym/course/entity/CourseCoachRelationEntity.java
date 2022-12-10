package io.renren.modules.gym.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程教练关联表
 * 
 * @author java
 * @email java
 * @date 2022-11-30 21:58:53
 */
@Data
@TableName("gym_course_coach_relation")
public class CourseCoachRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
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

}
