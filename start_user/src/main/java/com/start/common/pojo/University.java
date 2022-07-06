package com.start.common.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("university")
public class University {
    private Integer university_id;
    private String university_name, university_abbre, university_avatar;
}