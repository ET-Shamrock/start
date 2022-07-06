package com.start.common.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.start.common.mapper.UserMapper;
import com.start.common.pojo.requestResult.JsonData;
import com.start.common.pojo.User;
import com.start.common.service.UserService;
import com.start.common.utils.JwtUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 控制层
// springmvc框架自动为类创建对象，放至spring容器中
@RestController
public class UserController {
    // 从spring容器中取业务层对象
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    // 网页请求的hash map：url为key，其方法为value;请求该url时自动调用下面的方法
    @RequestMapping("/api/user/queryAll")
    public JsonData queryAllUser() {
        List<User> users = userService.queryAll();
        return new JsonData(20000, "Success", users);
    }

    @RequestMapping("/api/user/queryByEmail")
    public JsonData queryUser(JSONObject query_data) {
        String user_email = (String) query_data.get("user_email");
        User user = userService.queryUserByEmail(user_email);
        return new JsonData(20000, "Success", user);
    }
}
