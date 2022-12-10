package io.renren.modules.gym.equipment.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.gym.equipment.dao.EquipmentDao;
import io.renren.modules.gym.equipment.entity.EquipmentEntity;
import io.renren.modules.gym.equipment.service.EquipmentService;


@Service("equipmentService")
public class EquipmentServiceImpl extends ServiceImpl<EquipmentDao, EquipmentEntity> implements EquipmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EquipmentEntity> page = this.page(
                new Query<EquipmentEntity>().getPage(params),
                new QueryWrapper<EquipmentEntity>()
        );

        return new PageUtils(page);
    }

}