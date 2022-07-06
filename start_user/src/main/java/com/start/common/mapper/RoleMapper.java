package com.start.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.start.common.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from role")
    List<Role> queryAllRole();
}
