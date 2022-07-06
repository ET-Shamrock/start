package com.start.common.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@TableName("user_info")
public class UserInfo {
    private Integer user_id;
    private String user_nickname;
    private String user_avatar;
    private Integer role_id;

    public UserInfo(Integer user_id, String user_nickname, String user_avatar, Integer role_id) {
        this.user_id = user_id;
        this.user_nickname = user_nickname;
        this.user_avatar = user_avatar;
        this.role_id = role_id;
    }
}
