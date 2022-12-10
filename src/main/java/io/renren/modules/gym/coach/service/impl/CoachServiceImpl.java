package io.renren.modules.gym.coach.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.gym.coach.dao.CoachDao;
import io.renren.modules.gym.coach.entity.CoachEntity;
import io.renren.modules.gym.coach.service.CoachService;


@Service("coachService")
public class CoachServiceImpl extends ServiceImpl<CoachDao, CoachEntity> implements CoachService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CoachEntity> page = this.page(
                new Query<CoachEntity>().getPage(params),
                new QueryWrapper<CoachEntity>()
        );

        return new PageUtils(page);
    }

}