package io.renren.modules.ipcs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.dto.TreeNodeDTO;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ipcs.entity.DangerAreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 区域风险表
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
public interface DangerAreaService extends IService<DangerAreaEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<TreeNodeDTO> listTree(Map<String, Object> params);
}

