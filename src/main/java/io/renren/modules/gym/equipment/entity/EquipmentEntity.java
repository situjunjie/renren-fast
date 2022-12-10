package io.renren.modules.gym.equipment.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 器材表
 *
 * @author java
 * @email java
 * @date 2022-12-02 22:07:41
 */
@Data
@TableName("gym_equipment")
public class EquipmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 器材名称
	 */
	private String name;
	/**
	 * 效期日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date expriationDate;
	/**
	 * 生产商
	 */
	private String manufacture;
	/**
	 * 数量
	 */
	private Integer num;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date maintainDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date cleanDate;

	private Integer maintainFreq;

	private String fix;

}
