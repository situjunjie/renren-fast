package io.renren.modules.ipcs.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SendVo implements Serializable {

    private Long id;

    private String sender;

    private Integer num;
}
