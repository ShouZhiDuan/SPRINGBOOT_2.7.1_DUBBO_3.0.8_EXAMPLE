package com.nvclouds.medusaserver.impl;

import com.nvclouds.medusaapi.api.DemoDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/7/7 13:37
 * @Description:
 */
@Slf4j
@DubboService(version = "1.0.0")
public class DemoDubboServiceImpl implements DemoDubboService {

    @Override
    public Object hello() {
        log.info("version 1.0.0");
        return "version 1.0.0";
    }

    @Override
    public Object hello2(int age, String msg) {
        return null;
    }


}
