package io.renren.modules.gym.coach.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教练表
 * 
 * @author java
 * @email java
 * @date 2022-11-29 18:48:46
 */
@Data
@TableName("gym_coach")
public class CoachEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 教练姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 联系电话
	 */
	private String mobile;
	/**
	 * 擅长
	 */
	private String goodat;

}
