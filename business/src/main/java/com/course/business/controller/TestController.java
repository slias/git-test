package com.course.business.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: Silas
 * Date: 2020/6/5
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public  String test(){
        return "success";
    }
}
