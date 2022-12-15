package io.renren.modules.ipcs.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.renren.common.dto.TreeNodeDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.DangerAreaDao;
import io.renren.modules.ipcs.entity.DangerAreaEntity;
import io.renren.modules.ipcs.service.DangerAreaService;


@Service("dangerAreaService")
public class DangerAreaServiceImpl extends ServiceImpl<DangerAreaDao, DangerAreaEntity> implements DangerAreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DangerAreaEntity> page = this.page(
                new Query<DangerAreaEntity>().getPage(params),
                new QueryWrapper<DangerAreaEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<TreeNodeDTO> listTree(Map<String, Object> params) {
        //1.查出所有风险区域id
        Object dangerLevel = params.get("dangerLevel");
        LambdaQueryWrapper<DangerAreaEntity> queryWrapper = Wrappers.lambdaQuery(DangerAreaEntity.class).eq(dangerLevel != null,
                DangerAreaEntity::getLevel, dangerLevel);
        List<DangerAreaEntity> dangerAreaEntity = this.list(queryWrapper);
        if (CollectionUtil.isEmpty(dangerAreaEntity))
            return Collections.EMPTY_LIST;
        //1.低风险
        TreeNodeDTO firstLevel = new TreeNodeDTO();
        firstLevel.setLabel("低风险");

        return null;
    }

}
