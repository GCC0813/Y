package com.y.vo.in;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author GCC.
 * Created on 2019/3/5.
 */
@Data
public class LoginIn {
    @NotNull(message = "参数信息异常！")
    private String userName;

    @NotNull(message = "参数信息异常！")
    private String passWord;

}
