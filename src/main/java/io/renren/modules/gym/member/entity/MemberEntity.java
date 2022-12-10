package io.renren.modules.gym.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 用户表
 *
 * @author java
 * @email java
 * @date 2022-11-27 10:23:23
 */
@Data
@TableName("gym_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 会员姓名
	 */
	private String name;
	/**
	 * 会员性别
	 */
	private String gender;
	/**
	 * 电话号码
	 */
	private String mobile;
	/**
	 * 到期时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date expirationTime;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 生日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	/**
	 * 会员状态
	 */
	private String status;

	/**
	 * 卡状态
	 */
	private String cardType;

	/**
	 * 用户余额
	 */
	private BigDecimal price;


}
