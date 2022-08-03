package com.nvclouds.medusaserver.impl;

import com.nvclouds.medusaapi.api.DemoDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/7/7 13:37
 * @Description:
 */

@Slf4j
/**
 * version 表示版本号，可用可不用。用了则必须在调用方明确指出需要调用的版本号，否则会找不到提供服务。
 * 参考：{@link DubboService#version()}
 */
@DubboService(version = "2.0.0")
public class DemoDubboService2Impl implements DemoDubboService {

    @Override
    public Object hello() throws UnknownHostException {
        log.info("version 2.0.0");
        InetAddress ia = InetAddress.getLocalHost();
        return ia.getHostAddress(); //用于测试负载轮训
    }

    @Override
    public Object hello2(int age, String msg) {
        return null;
    }

}
