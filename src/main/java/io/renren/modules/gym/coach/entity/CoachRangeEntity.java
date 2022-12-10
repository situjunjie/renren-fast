package io.renren.modules.gym.coach.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教练评分
 *
 * @author java
 * @email java
 * @date 2022-12-07 19:21:36
 */
@Data
@TableName("gym_coach_range")
public class CoachRangeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 教练id
	 */
	private Long coachId;
	/**
	 * 评分
	 */
	private Integer score;
	/**
	 * 评价详情
	 */
	private String content;
	/**
	 * 评价人
	 */
	private String createBy;

}
