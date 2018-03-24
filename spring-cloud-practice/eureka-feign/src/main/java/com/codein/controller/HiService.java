package com.codein.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xhuanlee on 2018/3/24.
 */
@FeignClient("service-hi")
public interface HiService {

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    String sayHiFromFeign(@RequestParam(value = "name") String name);

}
