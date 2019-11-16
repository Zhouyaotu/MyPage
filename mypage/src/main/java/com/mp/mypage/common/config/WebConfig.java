package com.mp.mypage.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @description  该类用于配置静态文件访问路径的映射
 * @author 刘鑫源
 * @time 2019/11/16
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/16
 * @version 1.0
 */
@Configuration
@EnableConfigurationProperties(FileConfig.class)
public class WebConfig extends WebMvcConfigurationSupport {
    @Resource
    FileConfig fileConfig;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler(fileConfig.getAccessPath() + "/**")
                .addResourceLocations("file:" + fileConfig.getRealPath() + "/");
    }
}
