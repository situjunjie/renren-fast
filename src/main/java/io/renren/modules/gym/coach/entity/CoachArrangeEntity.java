package io.renren.modules.gym.coach.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教练排班表
 *
 * @author
 * @email
 * @date 2023-03-18 15:12:58
 */
@Data
@TableName("gym_coach_arrange")
public class CoachArrangeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 教练id
	 */
	private Long coachId;
	/**
	 * 关联课程id或会员id
	 */
	private Long relationId;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 状态(到岗、缺勤)
	 */
	private String status;

	private String relationType;

}
