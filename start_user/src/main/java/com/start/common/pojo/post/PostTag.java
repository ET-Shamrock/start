package com.start.common.pojo.post;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("post_tag")
public class PostTag {
    private Integer tag_id;
    private String tag_name;

    public PostTag(Integer tag_id, String tag_name) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}