package com.codein.controller;

import com.codein.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xhuanlee on 2018/3/24.
 */
@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @GetMapping("hi")
    public String sayHi(@RequestParam String name) {
        return hiService.sayHiFromFeign(name + "(feign)");
    }
}
