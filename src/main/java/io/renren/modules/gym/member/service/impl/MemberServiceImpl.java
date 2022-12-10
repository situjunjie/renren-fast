package io.renren.modules.gym.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.renren.common.utils.DateUtils;
import io.renren.common.validator.Assert;
import io.renren.modules.gym.member.CardTypeEnum;
import io.renren.modules.gym.member.controller.req.BuyCardRequestDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.gym.member.dao.MemberDao;
import io.renren.modules.gym.member.entity.MemberEntity;
import io.renren.modules.gym.member.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        LambdaQueryWrapper<MemberEntity> queryWrapper= new LambdaQueryWrapper<MemberEntity>();
        queryWrapper.like(Objects.nonNull(params.get("name")),MemberEntity::getName,params.get("name"))
                .like(Objects.nonNull(params.get("mobile")),MemberEntity::getMobile,params.get("mobile"));
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void buyCard(BuyCardRequestDTO buyCardRequestDTO) {
        //1.判断余额
        MemberEntity member = this.getById(buyCardRequestDTO.getMemberId());
        BigDecimal price = member.getPrice();
        CardTypeEnum cardTypeEnum = CardTypeEnum.getByCode(buyCardRequestDTO.getCardType());
        Assert.isTrue(
                price.compareTo(BigDecimal.valueOf(cardTypeEnum.getPrice())) <0
                ,"会员余额不足，请先充值");

        //2.扣款续期
        member.setPrice(member.getPrice().subtract(BigDecimal.valueOf(cardTypeEnum.getPrice())));
        switch (cardTypeEnum.getCode()){
            case 1://月卡
                member.setExpirationTime(DateUtils.addDateMonths(member.getExpirationTime(),1));
                break;
            case 2://季卡
                member.setExpirationTime(DateUtils.addDateMonths(member.getExpirationTime(),3));
                break;
            case 3://年卡
                member.setExpirationTime(DateUtils.addDateYears(member.getExpirationTime(),1));
                break;
            default:break;
        }
        this.updateById(member);
    }

}
