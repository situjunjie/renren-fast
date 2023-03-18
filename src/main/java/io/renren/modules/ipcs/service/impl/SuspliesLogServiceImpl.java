package io.renren.modules.ipcs.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.SuspliesLogDao;
import io.renren.modules.ipcs.entity.SuspliesLogEntity;
import io.renren.modules.ipcs.service.SuspliesLogService;


@Service("suspliesLogService")
public class SuspliesLogServiceImpl extends ServiceImpl<SuspliesLogDao, SuspliesLogEntity> implements SuspliesLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuspliesLogEntity> page = this.page(
                new Query<SuspliesLogEntity>().getPage(params),
                new QueryWrapper<SuspliesLogEntity>()
        );

        return new PageUtils(page);
    }

}