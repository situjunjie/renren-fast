package io.renren.modules.ipcs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.SurveyDao;
import io.renren.modules.ipcs.entity.SurveyEntity;
import io.renren.modules.ipcs.service.SurveyService;


@Service("surveyService")
public class SurveyServiceImpl extends ServiceImpl<SurveyDao, SurveyEntity> implements SurveyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object key = params.get("key");
        LambdaQueryWrapper<SurveyEntity> queryWrapper = Wrappers.lambdaQuery(SurveyEntity.class).like(key != null, SurveyEntity::getName, key);
        IPage<SurveyEntity> page = this.page(
                new Query<SurveyEntity>().getPage(params),queryWrapper
        );

        return new PageUtils(page);
    }

}
