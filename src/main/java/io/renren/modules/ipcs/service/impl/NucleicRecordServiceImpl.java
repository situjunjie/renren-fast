package io.renren.modules.ipcs.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.NucleicRecordDao;
import io.renren.modules.ipcs.entity.NucleicRecordEntity;
import io.renren.modules.ipcs.service.NucleicRecordService;


@Service("nucleicRecordService")
public class NucleicRecordServiceImpl extends ServiceImpl<NucleicRecordDao, NucleicRecordEntity> implements NucleicRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NucleicRecordEntity> page = this.page(
                new Query<NucleicRecordEntity>().getPage(params),
                new QueryWrapper<NucleicRecordEntity>()
        );

        return new PageUtils(page);
    }

}