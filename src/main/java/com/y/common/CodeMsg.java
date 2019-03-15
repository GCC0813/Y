package com.y.common;

/**
 * @author GCC
 * @date 2019-3-5
 */
public enum CodeMsg {
	
	SYSTEM_ERROR(500,"抱歉 系统开小差了！"),

    CODE_200(200, "成功"),

    CODE_1000(1000,"该用户不存在！");

    private Integer code;
    private String msg;

    CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
