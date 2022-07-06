package com.start.common.controller;

import com.start.common.mapper.CollegeMapper;
import com.start.common.mapper.PostTagMapper;
import com.start.common.mapper.RoleMapper;
import com.start.common.mapper.UniversityMapper;
import com.start.common.pojo.College;
import com.start.common.pojo.Role;
import com.start.common.pojo.University;
import com.start.common.pojo.post.PostTag;
import com.start.common.pojo.requestResult.JsonData;
import com.start.common.service.CommonService;
import com.start.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommonController {
    @Autowired
    CommonService commonService;

    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UniversityMapper universityMapper;
    @Autowired
    PostTagMapper postTagMapper;

    @RequestMapping("/api/common/consts")
    public Object getAllConsts() {
        System.out.println("/api/common/consts");
        List<College> colleges = collegeMapper.queryAllCollege();
        List<Role> roles = roleMapper.queryAllRole();
        List<University> universities = universityMapper.queryAllUniversity();
        List<PostTag> postTags = postTagMapper.queryAllPostTag();

        Map<String, Object> data = new HashMap<>();
        data.put("all_college", colleges);
        data.put("all_post_tag", postTags);
        data.put("all_university", universities);
        data.put("all_role", roles);
        return new JsonData(20000, "success", data);
    }
}
