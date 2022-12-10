package io.renren.modules.ipcs.dao;

import io.renren.modules.ipcs.entity.IsolationRuleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 隔离规则
 * 
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@Mapper
public interface IsolationRuleDao extends BaseMapper<IsolationRuleEntity> {
	
}
