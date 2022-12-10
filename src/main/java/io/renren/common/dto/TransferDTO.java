package io.renren.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @className: TransferDTO
 * @description: 前端穿梭框数据结构
 * @author: situjunjie
 * @date: 2022/11/30
 **/
@Data
public class TransferDTO implements Serializable {

    private static final long serialVersionUID = 5421487668686434952L;

    /**
     * 左侧节点
     */
    private List<TransferNodeDTO> leftData;

    /**
     * 右侧节点
     */
    private List<TransferNodeDTO> rigthData;


    @Data
    public static class TransferNodeDTO{
        private String key;

        private String label;

        private Boolean disabled;
    }


}
