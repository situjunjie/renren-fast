package io.renren.modules.gym.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 课程表
 *
 * @author java
 * @email java
 * @date 2022-11-29 23:39:45
 */
@Data
@TableName("gym_course")
public class CourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 课程名称
	 */
	private String name;
	/**
	 * 课程时长
	 */

	private Integer time;
	/**
	 * 注意事项
	 */
	private String tips;

}
