package com.start.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.start.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


// 自动为接口提供实现类，创建对象后放到spring容器中
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_email = #{user_email}")
    User selectByEmail(@Param("user_email") String user_email);
}


