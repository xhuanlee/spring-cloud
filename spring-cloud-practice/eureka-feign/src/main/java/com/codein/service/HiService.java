package com.codein.service;

import com.codein.service.impl.HiServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xhuanlee on 2018/3/24.
 */
@Service
@FeignClient(value = "service-hi", fallback = HiServiceImpl.class)
public interface HiService {

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    String sayHiFromFeign(@RequestParam(value = "name") String name);

}
