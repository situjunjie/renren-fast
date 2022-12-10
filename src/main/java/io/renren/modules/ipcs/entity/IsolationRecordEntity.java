package io.renren.modules.ipcs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 隔离记录
 * 
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@Data
@TableName("ipcs_isolation_record")
public class IsolationRecordEntity implements Serializable {
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
	 * 性别
	 */
	private String gender;
	/**
	 * 性别
	 */
	private Integer age;
	/**
	 * 隔离地点
	 */
	private String isolationAddr;
	/**
	 * 隔离类型
	 */
	private String type;
	/**
	 * 时长(天)
	 */
	private Integer time;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;

}
