package com.start.common.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 与数据库表一一对应的实体类
// 1、一定要创建带有所有属性为参数的构造函数；2、为所有的属性创建setter和getter
// user Table Data Access Object
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@TableName("user")
public class User {
    private Integer user_id;
    private String user_email;
    private String user_password;
    private Boolean user_disabled;

    public User(Integer user_id, String user_email, String user_password, Boolean user_disabled) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_disabled = user_disabled;
    }
}
