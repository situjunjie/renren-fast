package io.renren.modules.ipcs.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.renren.common.dto.TreeNodeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.IsolationRecordDao;
import io.renren.modules.ipcs.entity.IsolationRecordEntity;
import io.renren.modules.ipcs.service.IsolationRecordService;


@Service("isolationRecordService")
public class IsolationRecordServiceImpl extends ServiceImpl<IsolationRecordDao, IsolationRecordEntity> implements IsolationRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IsolationRecordEntity> page = this.page(
                new Query<IsolationRecordEntity>().getPage(params),
                new QueryWrapper<IsolationRecordEntity>()
        );

        return new PageUtils(page);
    }



}
