package com.codein.service.impl;

import com.codein.service.HiService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xhuanlee on 2018/3/24.
 */
@Component
public class HiServiceImpl implements HiService {

    @Override
    public String sayHiFromFeign(@RequestParam(value = "name") String name) {
        return String.format("opus, %s, error occurred", name);
    }
}
