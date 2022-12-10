package io.renren.modules.ipcs.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.IsolationRuleDao;
import io.renren.modules.ipcs.entity.IsolationRuleEntity;
import io.renren.modules.ipcs.service.IsolationRuleService;


@Service("isolationRuleService")
public class IsolationRuleServiceImpl extends ServiceImpl<IsolationRuleDao, IsolationRuleEntity> implements IsolationRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IsolationRuleEntity> page = this.page(
                new Query<IsolationRuleEntity>().getPage(params),
                new QueryWrapper<IsolationRuleEntity>()
        );

        return new PageUtils(page);
    }

}