package com.xiaofei.controller;

import com.xiaofei.service.FirstNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangrao on 2020/3/14.
 */
@RestController
public class LeiHou {

    @Autowired
    private FirstNameService firstNameService;

    @RequestMapping("index")
    public String hello(){
        return "leihou";
    }

    @RequestMapping("hello/{name}")
    public String morning(@PathVariable("name") String userName){
        System.out.println("come in");
        return firstNameService.sayHello(userName);
    }

}
