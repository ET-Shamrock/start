package com.start.common.service.impl;

import com.start.common.mapper.UniversityInfoMapper;
import com.start.common.service.UniversityService;
import com.start.common.pojo.UniversityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityInfoMapper universityInfoMapper;


    @Override
    public List<UniversityInfo> getUniversityInfo() {
        List<UniversityInfo> universityInfos = universityInfoMapper.selectList(null);
        return universityInfos;
    }
}
