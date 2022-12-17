package io.renren.common.dto;

import lombok.Data;

import java.util.List;

/**
 * @className: TreeNodeDTO
 * @description: 树形数据结构DTO
 * @author: situjunjie
 * @date: 2022/12/11
 **/
@Data
public class TreeNodeDTO {

    private Long id;

    private String label;

    private List<TreeNodeDTO> childrens;

    private Boolean disabled;

    private Boolean isLeaf;

    private Integer dangerLevel;
}
