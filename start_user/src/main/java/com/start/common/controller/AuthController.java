package com.start.common.controller;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.start.common.mapper.UserMapper;
import com.start.common.pojo.User;
import com.start.common.pojo.UserInfo;
import com.start.common.pojo.requestResult.JsonData;
import com.start.common.pojo.requestResult.MessageJson;
import com.start.common.service.UserService;
import com.start.common.service.AuthService;
import com.start.common.utils.JsonUtils;
import com.start.common.utils.JwtUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    Map<Integer, String> state = new HashMap<Integer, String>() {
        {
            put(4004, "用户名不存在");
            put(20000, "验证成功");
            put(5001, "密码错误");}
    };

    @RequestMapping("/api/user/login")
    public Object Login(@RequestBody String query_data) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("api"+query_data);
        JSONObject json = new JSONObject(query_data);
        String username = json.getString("username");
        User user = userService.queryUserByEmail(username);

        Integer code = 20000;
        if (user == null) {
            // 查无此用户
            code = 4004;
            return new MessageJson(code, state.get(code));
        }
        String token = authService.VerifyPassword(user, json.getString("password"));
        if (token == null) {
            code = 5001;
            return new MessageJson(code, state.get(code));
        }
        Map<String, Object> data = JsonUtils.init("token", token);
        return new JsonData(code, state.get(code), data);
    }

    @RequestMapping("/api/user/info")
    public Object UserInfo(@RequestHeader(value="Authorization") String token) {
        UserInfo info = (UserInfo) authService.queryInfoByToken(token);
        if (info == null) {
            return new MessageJson(5001, "用户信息查询失败！");
        }
        return new JsonData(20000, "success", info);
    }
}
