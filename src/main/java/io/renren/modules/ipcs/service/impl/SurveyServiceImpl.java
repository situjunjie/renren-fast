package io.renren.modules.ipcs.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
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
        IPage<SurveyEntity> page = this.page(
                new Query<SurveyEntity>().getPage(params),
                new QueryWrapper<SurveyEntity>()
        );

        return new PageUtils(page);
    }

}