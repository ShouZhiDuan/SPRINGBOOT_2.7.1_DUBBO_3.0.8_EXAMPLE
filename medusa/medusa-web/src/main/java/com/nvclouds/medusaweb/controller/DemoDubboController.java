package com.nvclouds.medusaweb.controller;

import com.nvclouds.medusaapi.api.DemoDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.UnknownHostException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/7/7 13:57
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class DemoDubboController {

    @DubboReference(
            version = "2.0.0" //表示指定服务端版本调用
            //url = "192.168.50.175:20880" //表示直连调用，配置了这个nacos远程服务调用将会被忽略.
    )
    private DemoDubboService demoDubboService;

    @GetMapping("/dubbo")
    public Object hello() throws UnknownHostException {
        return  demoDubboService.hello();
    }

}
