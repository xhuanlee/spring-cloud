package com.codein.controller;

import com.codein.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xhuanlee on 2018/3/24.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("hi")
    @ResponseBody
    public String hiService(@RequestParam String name) {
        return helloService.hiService(name + "(ribbon)");
    }

}
