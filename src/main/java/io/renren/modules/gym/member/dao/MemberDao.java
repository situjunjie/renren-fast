package io.renren.modules.gym.member.dao;

import io.renren.modules.gym.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author java
 * @email java
 * @date 2022-11-27 10:23:23
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
