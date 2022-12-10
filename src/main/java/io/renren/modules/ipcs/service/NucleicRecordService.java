package io.renren.modules.ipcs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ipcs.entity.NucleicRecordEntity;

import java.util.Map;

/**
 * 核酸记录
 *
 * @author java
 * @email java
 * @date 2022-12-10 20:31:42
 */
public interface NucleicRecordService extends IService<NucleicRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

