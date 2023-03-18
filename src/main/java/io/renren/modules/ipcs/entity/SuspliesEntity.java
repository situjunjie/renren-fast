package io.renren.modules.ipcs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物资表
 * 
 * @author 
 * @email 
 * @date 2023-02-28 21:01:20
 */
@Data
@TableName("ipcs_susplies")
public class SuspliesEntity implements Serializable {
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
	 * 物资状态
	 */
	private String status;
	/**
	 * 物资数量
	 */
	private Integer num;
	/**
	 * 出库时间
	 */
	private Date sendTime;
	/**
	 * 入库时间
	 */
	private Date inTime;
	/**
	 * 出库人
	 */
	private String sender;
	/**
	 * 入库人
	 */
	private String receiver;

}
