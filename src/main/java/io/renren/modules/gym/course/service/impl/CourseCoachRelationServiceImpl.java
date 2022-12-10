package io.renren.modules.gym.course.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.renren.common.dto.TransferDTO;
import io.renren.modules.gym.coach.entity.CoachEntity;
import io.renren.modules.gym.coach.service.CoachService;
import io.renren.modules.gym.course.controller.req.CourseCoachRelationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.gym.course.dao.CourseCoachRelationDao;
import io.renren.modules.gym.course.entity.CourseCoachRelationEntity;
import io.renren.modules.gym.course.service.CourseCoachRelationService;


@Service("courseCoachRelationService")
public class CourseCoachRelationServiceImpl extends ServiceImpl<CourseCoachRelationDao, CourseCoachRelationEntity> implements CourseCoachRelationService {

    @Autowired
    private CoachService coachService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseCoachRelationEntity> page = this.page(
                new Query<CourseCoachRelationEntity>().getPage(params),
                new QueryWrapper<CourseCoachRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public TransferDTO listCoachTransfer(Long courseId) {
        TransferDTO transferDTO = new TransferDTO();
        //1.查询所有教练
        List<CoachEntity> list = coachService.list();

        List<TransferDTO.TransferNodeDTO> left = list.stream().map(coach -> {
            TransferDTO.TransferNodeDTO transferNodeDTO = new TransferDTO.TransferNodeDTO();
            transferNodeDTO.setDisabled(Boolean.FALSE);
            transferNodeDTO.setKey(String.valueOf(coach.getId()));
            transferNodeDTO.setLabel(coach.getName());
            return transferNodeDTO;
        }).collect(Collectors.toList());
        List<TransferDTO.TransferNodeDTO> right = new ArrayList<>();
        transferDTO.setLeftData(left);
        transferDTO.setRigthData(right);
        //2.查询已经选择的教练
        LambdaQueryWrapper<CourseCoachRelationEntity> queryWrapper = Wrappers.lambdaQuery(CourseCoachRelationEntity.class)
                .eq(CourseCoachRelationEntity::getCourseId, courseId);
        List<CourseCoachRelationEntity> relationList = this.list(queryWrapper);
        List<Long> coachSelectedIds = relationList.stream().map(CourseCoachRelationEntity::getCoachId).collect(Collectors.toList());
        if(CollectionUtil.isNotEmpty(coachSelectedIds)){
        List<CoachEntity> selectedCoach = coachService.listByIds(coachSelectedIds);
        right = selectedCoach.stream().map(coach -> {
            TransferDTO.TransferNodeDTO transferNodeDTO = new TransferDTO.TransferNodeDTO();
            transferNodeDTO.setDisabled(Boolean.FALSE);
            transferNodeDTO.setKey(String.valueOf(coach.getId()));
            transferNodeDTO.setLabel(coach.getName());
            return transferNodeDTO;
        }).collect(Collectors.toList());
        transferDTO.setRigthData(right);
        }

        return transferDTO;
    }

    @Override
    public void updateCourseCoachRelation(CourseCoachRelationUpdateRequest request) {
        //1.先删除
        LambdaQueryWrapper<CourseCoachRelationEntity> deleteWrapper = Wrappers.lambdaQuery(CourseCoachRelationEntity.class)
                .eq(CourseCoachRelationEntity::getCourseId, request.getCourseId());
        this.remove(deleteWrapper);
        //2.再新增
        List<CourseCoachRelationEntity> updateEntity = request.getCoachIds().stream().map(req -> {
            CourseCoachRelationEntity entity = new CourseCoachRelationEntity();
            entity.setCourseId(request.getCourseId());
            entity.setCoachId(Long.valueOf(req));
            return entity;
        }).collect(Collectors.toList());
        this.saveBatch(updateEntity);
    }

}
