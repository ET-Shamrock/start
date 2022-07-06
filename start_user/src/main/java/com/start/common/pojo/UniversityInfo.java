package com.start.common.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@TableName("university_info")
public class UniversityInfo {
    Integer university_id;
    Integer university_local_rank;
    Integer university_qs_rank;

    public UniversityInfo(Integer university_id, Integer university_local_rank, Integer university_qs_rank) {
        this.university_id = university_id;
        this.university_local_rank = university_local_rank;
        this.university_qs_rank = university_qs_rank;
    }
}
