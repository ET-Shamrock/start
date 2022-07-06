package com.start.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.start.common.pojo.Role;
import com.start.common.pojo.University;
import com.start.common.pojo.UniversityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UniversityMapper extends BaseMapper<University> {
    @Select("select * from university")
    List<University> queryAllUniversity();
}
