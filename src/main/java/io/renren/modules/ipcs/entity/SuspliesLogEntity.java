package io.renren.modules.ipcs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 入出库记录
 * 
 * @author 
 * @email 
 * @date 2023-03-01 13:49:05
 */
@Data
@TableName("ipcs_susplies_log")
public class SuspliesLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 物资名称
	 */
	private String name;
	/**
	 * 数量
	 */
	private Integer num;
	/**
	 * 入出库时间
	 */
	private Date logTime;
	/**
	 * 入出库动作
	 */
	private String type;
	/**
	 * 操作人
	 */
	private String operator;

}
