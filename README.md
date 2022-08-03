# 新平台

## 一、组织结构

``` lua
medusa-skadi
├── medusa(中心协调调度平台)
├── medusa-api -- 调度中心API
├── medusa-web -- 调度中心RESTFUL API
├── medusa-server -- 调度中心DUBBO RPC服务实现层
├── skadi(本地计算端)
├── skadi-api -- 本地计算API
├── skadi-web -- 本地计算RESTFUL API
├── skadi-server -- 本地计算DUBBO RPC服务实现层
```

## 二、前端技术

| 技术       | 说明                  |
| ---------- | --------------------- | 
| Vue        | 前端框架              | 

## 三、后端技术
| 技术                 | 说明                |版本               |
| -------------------- | ------------------- |------------------- |
| SpringBoot           | 容器+MVC框架        | 2.7.1              | 
| Dubbo                | 微服务框架          | 3.0.8              | 
| Nacos                | 注册配置中心        | 2.0.4              | 