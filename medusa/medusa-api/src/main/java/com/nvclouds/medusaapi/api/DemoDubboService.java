package com.nvclouds.medusaapi.api;

import java.net.UnknownHostException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/7/7 12:15
 * @Description:
 */
public interface DemoDubboService {
     Object hello() throws UnknownHostException;

     Object hello2(int age, String msg);
}
