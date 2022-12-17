package io.renren.modules.ipcs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 区域表
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@Data
@TableName("ipcs_area")
public class AreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 上级区域id
	 */
	private Long parentId;
	/**
	 * 层级
	 */
	private Integer level;

	/**
	 * 风险等级 0 无风险 1：低风险  2：中风险  3：高风险
	 */
	private Integer dangerLevel;

}
