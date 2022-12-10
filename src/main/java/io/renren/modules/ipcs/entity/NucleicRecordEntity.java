package io.renren.modules.ipcs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 核酸记录
 * 
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@Data
@TableName("ipcs_nucleic_record")
public class NucleicRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idNo;
	/**
	 * 采集时间
	 */
	private Date sampleTime;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 结果
	 */
	private String result;
	/**
	 * 报告时间
	 */
	private Date reportTime;

}
