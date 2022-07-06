package com.start.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.start.common.pojo.post.PostTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostTagMapper extends BaseMapper<PostTag> {
    @Select("select * from post_tag")
    List<PostTag> queryAllPostTag();
}
