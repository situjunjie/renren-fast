package io.renren.modules.gym.equipment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.equipment.entity.EquipmentEntity;

import java.util.Map;

/**
 * 器材表
 *
 * @author java
 * @email java
 * @date 2022-12-02 22:07:41
 */
public interface EquipmentService extends IService<EquipmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

