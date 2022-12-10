package io.renren.modules.ipcs.dao;

import io.renren.modules.ipcs.entity.IsolationRecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 隔离记录
 * 
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
@Mapper
public interface IsolationRecordDao extends BaseMapper<IsolationRecordEntity> {
	
}
