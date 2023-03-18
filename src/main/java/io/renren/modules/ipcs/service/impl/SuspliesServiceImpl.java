package io.renren.modules.ipcs.service.impl;

import io.renren.modules.ipcs.entity.SuspliesLogEntity;
import io.renren.modules.ipcs.entity.vo.ReceiveVo;
import io.renren.modules.ipcs.entity.vo.SendVo;
import io.renren.modules.ipcs.service.SuspliesLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ipcs.dao.SuspliesDao;
import io.renren.modules.ipcs.entity.SuspliesEntity;
import io.renren.modules.ipcs.service.SuspliesService;


@Service("suspliesService")
public class SuspliesServiceImpl extends ServiceImpl<SuspliesDao, SuspliesEntity> implements SuspliesService {

    @Autowired
    private SuspliesLogService suspliesLogService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuspliesEntity> page = this.page(
                new Query<SuspliesEntity>().getPage(params),
                new QueryWrapper<SuspliesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void receive(ReceiveVo receiveVo) {
        SuspliesEntity suspliesEntity = new SuspliesEntity();
        suspliesEntity.setName(receiveVo.getName());
        suspliesEntity.setReceiver(receiveVo.getReceiver());
        suspliesEntity.setNum(receiveVo.getNum());
        suspliesEntity.setStatus("已入库");
        suspliesEntity.setInTime(new Date());
        SuspliesLogEntity suspliesLogEntity = new SuspliesLogEntity();
        suspliesLogEntity.setOperator(receiveVo.getReceiver());
        suspliesLogEntity.setName(receiveVo.getName());
        suspliesLogEntity.setNum(receiveVo.getNum());
        suspliesLogEntity.setLogTime(new Date());
        suspliesLogEntity.setType("入库");
        suspliesLogService.save(suspliesLogEntity);
        this.baseMapper.insert(suspliesEntity);
    }

    @Override
    public void send(SendVo sendVo) {
        SuspliesEntity suspliesEntity = this.baseMapper.selectById(sendVo.getId());
        suspliesEntity.setSender(sendVo.getSender());
        suspliesEntity.setNum(suspliesEntity.getNum() - sendVo.getNum());
        suspliesEntity.setSendTime(new Date());
        if (Objects.equals(suspliesEntity.getNum(),0)){
            suspliesEntity.setStatus("全部出库");
        }else{
            suspliesEntity.setStatus("部分出库");
        }
        SuspliesLogEntity suspliesLogEntity = new SuspliesLogEntity();
        suspliesLogEntity.setOperator(sendVo.getSender());
        suspliesLogEntity.setName(suspliesEntity.getName());
        suspliesLogEntity.setNum(sendVo.getNum());
        suspliesLogEntity.setLogTime(new Date());
        suspliesLogEntity.setType("出库");
        suspliesLogService.save(suspliesLogEntity);
        this.baseMapper.updateById(suspliesEntity);
    }

}
