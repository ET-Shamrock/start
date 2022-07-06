package com.start.common.controller;

import com.start.common.pojo.requestResult.JsonData;
import com.start.common.pojo.UniversityInfo;
import com.start.common.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @RequestMapping("/api/university/queryAll")
    public JsonData queryAllUniversity() {
        List<UniversityInfo> res = universityService.getUniversityInfo();
        return new JsonData(20000, "Success", res);
    }
}
