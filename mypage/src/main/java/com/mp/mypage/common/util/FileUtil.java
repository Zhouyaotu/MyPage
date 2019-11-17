package com.mp.mypage.common.util;

import com.mp.mypage.common.Constant;
import com.mp.mypage.common.Result;
import com.mp.mypage.common.config.FileConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @description 该类用于文件的传输
 * @author 刘鑫源
 * @time 2019/11/16
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/16
 * @version 1.0
 */
@Component
@EnableConfigurationProperties(FileConfig.class)
public class FileUtil {
    @Resource
    FileConfig fileConfig;

    /**
     * 该方法用于上传文件到指定目录
     * @param file 待上传的文件
     * @param directory 文件保存目录， 可选值有Constant类中的IMG_HEAD/IMG_COMMON/VOICE/VEDIO
     * @return 上传结果， 操作成功时包含文件访问位置fileUrl
     */
    public Result upload(MultipartFile file, String directory){
        if(file.isEmpty())
            return new Result(Constant.FILE_EMPTY, "文件为空");
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        String imgRealPath = fileConfig.getRealPath() + "/" + directory;
        String imgAccessPath = fileConfig.getAccessPath() + "/" + directory;
        String destFilename = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
        String fileUrl = imgAccessPath + "/" + destFilename;

        File destFile = new File(imgRealPath, destFilename);
        if(!destFile.getParentFile().exists())
            destFile.getParentFile().mkdirs();

        try {
            file.transferTo(destFile);
            return new Result(Constant.OPERATOR_SUCCESS, null).addAttribute(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(Constant.FILE_STORGE_FAIL, "文件存储失败");
        }
    }
}
