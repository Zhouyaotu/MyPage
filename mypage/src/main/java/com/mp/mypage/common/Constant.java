package com.mp.mypage.common;

/**
 * @description 全局常量值
 * @author 刘鑫源
 * @time 2019/11/16
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/16
 * @version 1.0
 */
public class Constant {
    //==============================================
    //                操作结果常量
    //==============================================
    /**          结果码为0总表示操作成功          */
    public static final int OPERATOR_SUCCESS = 0;

    public static final int NOT_IMPLEMENT = -1;

    public static final int ACCOUNT_EXIST = 2;
    public static final int ACCOUNT_NOT_EXIST = 3;
    public static final int ACCOUNT_BAN = 4;
    public static final int ACCOUNT_FREEZE = 5;

    public static final int PASSWORD_WRONG = 6;

    public static final int FILE_EMPTY = 7;
    public static final int FILE_STORGE_FAIL = 8;
    public static final int FILE_TOO_BIG = 9;

    //==============================================
    //                字段状态常量
    //==============================================
    public static final byte LABEL_CHARACHTER = 0;
    public static final byte LABEL_INTEREST = 1;
    public static final byte LABEL_SKILL = 2;

    //==============================================
    //                文件目录常量
    //==============================================
    public static final String IMG_COMMON = "img/common";
    public static final String IMG_HEAD = "img/head";
    public static final String VEDIO = "vedio";
    public static final String VOCICE = "voice";


}
