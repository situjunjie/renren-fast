package io.renren.modules.ipcs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ipcs.entity.SuspliesEntity;
import io.renren.modules.ipcs.entity.vo.ReceiveVo;
import io.renren.modules.ipcs.entity.vo.SendVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 物资表
 *
 * @author
 * @email
 * @date 2023-02-28 21:01:20
 */
public interface SuspliesService extends IService<SuspliesEntity> {



    PageUtils queryPage(Map<String, Object> params);

    void receive(ReceiveVo receiveVo);

    void send(SendVo sendVo);
}

