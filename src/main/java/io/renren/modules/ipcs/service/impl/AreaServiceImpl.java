package io.renren.modules.ipcs.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.renren.common.dto.TreeNodeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.AreaDao;
import io.renren.modules.ipcs.entity.AreaEntity;
import io.renren.modules.ipcs.service.AreaService;


@Service("areaService")
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AreaEntity> page = this.page(
                new Query<AreaEntity>().getPage(params),
                new QueryWrapper<AreaEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<TreeNodeDTO> listTree(Map<String, Object> params) {
        Object level = params.get("level");
        Object parentId = params.get("parentId");
        LambdaQueryWrapper<AreaEntity> queryWrapper = Wrappers.lambdaQuery(AreaEntity.class)
                .eq(Objects.isNull(parentId), AreaEntity::getParentId, 0)
                .eq(Objects.nonNull(parentId),AreaEntity::getParentId,parentId);
        List<AreaEntity> list = list(queryWrapper);
        List<TreeNodeDTO> treeNodeDTOS = list.stream().map(area -> {
            TreeNodeDTO treeNodeDTO = new TreeNodeDTO();
            treeNodeDTO.setId(area.getId());
            treeNodeDTO.setLabel(area.getName());
            treeNodeDTO.setDangerLevel(area.getDangerLevel());
            return treeNodeDTO;
        }).collect(Collectors.toList());
        return treeNodeDTOS;
    }

    @Override
    public void updateDangerLevel(Map<String, Object> params) {
        Long id = (Long) params.get("id");
        Boolean overChildren = (Boolean) params.get("overChildren");
        Integer dangerLevel = (Integer) params.get("dangerLevel");
        AreaEntity area = this.getById(id);
        area.setDangerLevel( dangerLevel);
        this.updateById(area);
        if(overChildren)
            updateChildrenDangerLevel(id,dangerLevel);
    }

    private void updateChildrenDangerLevel(Long parentId, Integer level) {
        LambdaQueryWrapper<AreaEntity> queryWrapper = Wrappers.lambdaQuery(AreaEntity.class).eq(AreaEntity::getParentId, parentId);
        List<AreaEntity> list = this.list(queryWrapper);
        if(CollectionUtil.isEmpty(list))
            return;
        list.forEach(areaEntity -> {
            areaEntity.setDangerLevel(level);
        });
        this.updateBatchById(list);
        list.stream().map(AreaEntity::getId)
                .forEach(id->{updateChildrenDangerLevel(id,level);});
    }

}
