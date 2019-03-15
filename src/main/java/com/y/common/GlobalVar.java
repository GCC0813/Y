package com.y.common;

/**
 * @author GCC
 * 全局变量类
 */
public class GlobalVar {
    //redis 过期时间 单位/小时
    public static final int Timeout_Default = 24;

    //status 状态码
    public static final int Status_Ok = 200;
    public static final int Status_BadRequest = 404;
    public static final int Status_BadRequestParam = 400;
    public static final int Status_ServerErr = 500;
    //分页
//    public static final int PageNum_Default = 1;
    public static final int PagePer_Default = 10;
    public static final int PageNum_ListByStudent = 1;
    public static final int PagePer_ListByStudent = 10;
    public static final int PageNum_ListByTeacher = 1;
    public static final int PagePer_ListByTeacher = 10;

    //jwt 配置
    public static final String SRC = "Src";
    public static final String IP = "Ip";
    public static final String USERID = "UserId";
    public static final String USERTYPE = "UserType";
    public static final String ROLE = "role";
    //    public static final String HITS = "hits";
    public static final String TTLS = "ttls";
    public static final int TTLS_VALUE = 86400;// 24小时
    
    // app
    public static final String VERSION = "version";
    public static final String APPLICATION = "application";
    public static final String DEVICE = "device";
    public static final String CLIENTTYPE = "clientType";
    public static final String UID = "uid";
    
    
    //异常类型 0正常 
    public static final int CLAIMSEXCEPTIONTYPE_0=0;
    //-1格式错误
    public static final int CLAIMSEXCEPTIONTYPE_1=-1;
    //-2已过期
    public static final int CLAIMSEXCEPTIONTYPE_2=-2;
    //-3非法
    public static final int CLAIMSEXCEPTIONTYPE_3=-3;
    //-4未提供
    public static final int CLAIMSEXCEPTIONTYPE_4=-4;
    
}
