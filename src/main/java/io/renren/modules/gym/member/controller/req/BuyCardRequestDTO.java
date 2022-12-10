package io.renren.modules.gym.member.controller.req;

import lombok.Data;

/**
 * @className: BuyCardRequestDTO
 * @description:
 * @author: situjunjie
 * @date: 2022/11/29
 **/
@Data
public class BuyCardRequestDTO {

    private Long memberId;

    private Integer cardType;
}
