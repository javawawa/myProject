package com.twosmall.controller;

import com.twosmall.domain.TestSelfValue;
import com.twosmall.domain.TestValue;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/restSwagger")
@RestController
public class SwaggerRestController {

    @Autowired
    TestValue testValue;
    @Autowired
    TestSelfValue testSelfValue;

    @ApiOperation(value = "用于查询用户" ,  notes="查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/queryUser",method=RequestMethod.GET)
    public List<Map<String,String>> queryUser(@RequestParam("userId") String userId){
        userId = testValue.getValue();
        System.out.println("queryUser:::"+userId);
        System.out.println("queryUser:--:"+testValue.getTitle());
        List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<>();
        map.put("userId", "123123");
        map.put("name", "张三");
        returnList.add(map);
        return returnList;
    }

}
