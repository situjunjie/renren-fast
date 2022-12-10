package io.renren.modules.ipcs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 流调记录
 * 
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@Data
@TableName("ipcs_survey")
public class SurveyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 职业
	 */
	private String occupy;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 是否发热
	 */
	private String fever;
	/**
	 * 体温
	 */
	private Double temperature;
	/**
	 * 近14天是否有中、高风险区域旅居史
	 */
	private String content1;
	/**
	 * 是否密接、次密接
	 */
	private String content2;
	/**
	 * 是否有与次密接、密接患者有时空接触
	 */
	private String content3;

}
