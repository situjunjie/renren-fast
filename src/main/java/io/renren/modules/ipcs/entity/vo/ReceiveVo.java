package io.renren.modules.ipcs.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReceiveVo implements Serializable {

    private String name;

    private String receiver;

    private Integer num;
}
