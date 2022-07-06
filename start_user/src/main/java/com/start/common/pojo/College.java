package com.start.common.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@TableName("college")
public class College {
    private Integer college_id;
    private String college_name;

    public College(Integer college_id, String college_name) {
        this.college_id = college_id;
        this.college_name = college_name;
    }
}
