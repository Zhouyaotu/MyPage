package com.mp.mypage.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description 该类用于获取有关文件传输的配置信息
 * @author 刘鑫源
 * @time 2019/11/16
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/16
 * @version 1.0
 */
@Component
@ConfigurationProperties(prefix = "mypage.file")
public class FileConfig {
    private String realPath;
    private String accessPath;

    @Override
    public String toString() {
        return "FileConfig{" +
                "realPath='" + realPath + '\'' +
                ", accessPath='" + accessPath + '\'' +
                '}';
    }

    public String getRealPath() {
        return realPath;
    }

    public FileConfig setRealPath(String realPath) {
        this.realPath = realPath;
        return this;
    }

    public String getAccessPath() {
        return accessPath;
    }

    public FileConfig setAccessPath(String accessPath) {
        this.accessPath = accessPath;
        return this;
    }
}
