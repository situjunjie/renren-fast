package io.renren.modules.gym.coach.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.gym.coach.dao.CoachArrangeDao;
import io.renren.modules.gym.coach.entity.CoachArrangeEntity;
import io.renren.modules.gym.coach.service.CoachArrangeService;


@Service("coachArrangeService")
public class CoachArrangeServiceImpl extends ServiceImpl<CoachArrangeDao, CoachArrangeEntity> implements CoachArrangeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CoachArrangeEntity> page = this.page(
                new Query<CoachArrangeEntity>().getPage(params),
                new QueryWrapper<CoachArrangeEntity>()
        );

        return new PageUtils(page);
    }

}