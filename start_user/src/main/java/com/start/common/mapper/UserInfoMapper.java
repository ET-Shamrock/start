package com.start.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.start.common.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

// 可以在mapper中写原生sql，相当于定义了一些视图，方便查询
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select * from user_info \n" +
            "where user_id = #{user_id}")
    UserInfo selectByID(@Param("user_id") String user_id);
}
