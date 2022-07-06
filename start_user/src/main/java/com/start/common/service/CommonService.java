package com.start.common.service;

import com.start.common.mapper.CollegeMapper;
import com.start.common.mapper.PostTagMapper;
import com.start.common.mapper.RoleMapper;
import com.start.common.mapper.UniversityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UniversityMapper universityMapper;
    @Autowired
    PostTagMapper postTagMapper;

//    public
}
