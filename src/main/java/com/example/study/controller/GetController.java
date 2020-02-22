package com.example.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //localhost:8080/api에 매핑됨
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // /api/getMethod에 매핑
    public String getRequest(){
        return "Hi getMethod";
    }
    


}
