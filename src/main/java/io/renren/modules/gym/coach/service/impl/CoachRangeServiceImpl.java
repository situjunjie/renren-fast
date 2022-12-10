package io.renren.modules.gym.coach.service.impl;

import io.renren.modules.gym.coach.entity.CoachRangeResp;
import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.gym.coach.dao.CoachRangeDao;
import io.renren.modules.gym.coach.entity.CoachRangeEntity;
import io.renren.modules.gym.coach.service.CoachRangeService;


@Service("coachRangeService")
public class CoachRangeServiceImpl extends ServiceImpl<CoachRangeDao, CoachRangeEntity> implements CoachRangeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<CoachRangeEntity> page = this.page(
//                new Query<CoachRangeEntity>().getPage(params),
//                new QueryWrapper<CoachRangeEntity>()
//        );

//        IPage<CourseDetailResp> courseDetailRespIPage = this.baseMapper.pageCourseDetail(new Query<CourseDetailResp>().getPage(params),
//                params);

        IPage<CoachRangeResp> page = this.baseMapper.pageCoachRange(new Query<CoachRangeResp>().getPage(params),params);
        return new PageUtils(page);
    }

}
