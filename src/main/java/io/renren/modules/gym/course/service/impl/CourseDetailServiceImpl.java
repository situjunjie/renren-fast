package io.renren.modules.gym.course.service.impl;

import io.renren.modules.gym.coach.service.CoachService;
import io.renren.modules.gym.course.entity.CourseDetailResp;
import io.renren.modules.gym.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.gym.course.dao.CourseDetailDao;
import io.renren.modules.gym.course.entity.CourseDetailEntity;
import io.renren.modules.gym.course.service.CourseDetailService;


@Service("courseDetailService")
public class CourseDetailServiceImpl extends ServiceImpl<CourseDetailDao, CourseDetailEntity> implements CourseDetailService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CoachService coachService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

//        IPage<CourseDetailEntity> page = this.page(
//                new Query<CourseDetailEntity>().getPage(params),
//                new QueryWrapper<CourseDetailEntity>()
//        );
        IPage<CourseDetailResp> courseDetailRespIPage = this.baseMapper.pageCourseDetail(new Query<CourseDetailResp>().getPage(params),
                params);

        return new PageUtils(courseDetailRespIPage);
    }

}
