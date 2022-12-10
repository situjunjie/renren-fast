package io.renren.modules.gym.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @className: CardTypeEnum
 * @description:
 * @author: situjunjie
 * @date: 2022/11/29
 **/
@Getter
@AllArgsConstructor
public enum CardTypeEnum {

    MONTH(1,"月卡",100),SEASON(2,"季卡",200),YEAR(3,"年卡",600);

    private Integer code;

    private String name;

    private Integer price;

    public static List<Integer> getAllCode(){
        return Arrays.stream(values()).map(CardTypeEnum::getCode).collect(Collectors.toList());
    }

    public static CardTypeEnum getByCode(Integer code){
        return Arrays.stream(values()).filter(a->Objects.equals(a.code,code)).findFirst().orElse(MONTH);
    }
}
