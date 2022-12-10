package io.renren.modules.gym.equipment.dao;

import io.renren.modules.gym.equipment.entity.EquipmentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 器材表
 * 
 * @author java
 * @email java
 * @date 2022-12-02 22:07:41
 */
@Mapper
public interface EquipmentDao extends BaseMapper<EquipmentEntity> {
	
}
