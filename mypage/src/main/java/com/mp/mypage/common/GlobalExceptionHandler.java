package com.mp.mypage.common;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @description 该类用于全局异常处理
 * @author 刘鑫源
 * @time 2019/11/16
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/16
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * 该方法用于处理因文件过大引发的上传异常
     * @param e 多体文件上传异常
     * @return 异常处理结果
     */
    @ExceptionHandler(value = MultipartException.class)
    public Result FileUploadExceptionHandler(MultipartException e){
        if(e.getCause().getCause() instanceof FileUploadBase.FileSizeLimitExceededException){
            return new Result(Constant.FILE_TOO_BIG, "上传的文件过大");
        } else if(e.getCause().getCause() instanceof FileUploadBase.SizeLimitExceededException){
            return new Result(Constant.FILE_TOO_BIG, "上传的文件过大");
        } else{
            return new Result(Constant.FILE_TOO_BIG, "服务器异常");
        }
    }
}
