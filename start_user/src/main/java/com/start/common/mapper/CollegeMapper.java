package com.start.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.start.common.pojo.College;
import com.start.common.pojo.UniversityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollegeMapper extends BaseMapper<College> {
    @Select("select * from college")
    List<College> queryAllCollege();
}
