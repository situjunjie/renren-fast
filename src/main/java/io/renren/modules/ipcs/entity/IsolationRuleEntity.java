package io.renren.modules.ipcs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 隔离规则
 * 
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@Data
@TableName("ipcs_isolation_rule")
public class IsolationRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 隔离类型
	 */
	private String type;
	/**
	 * 时长(天)
	 */
	private Integer time;
	/**
	 * 风险等级
	 */
	private String dangerLevel;

}
