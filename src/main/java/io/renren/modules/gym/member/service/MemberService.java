package io.renren.modules.gym.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.gym.member.controller.req.BuyCardRequestDTO;
import io.renren.modules.gym.member.entity.MemberEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author java
 * @email java
 * @date 2022-11-27 10:23:23
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 买卡
     * @param buyCardRequestDTO
     */
    void buyCard(BuyCardRequestDTO buyCardRequestDTO);
}

