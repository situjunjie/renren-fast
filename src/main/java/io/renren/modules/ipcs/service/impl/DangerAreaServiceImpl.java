package io.renren.modules.ipcs.service.impl;

import org.springframework.stereotype.Service;
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

}