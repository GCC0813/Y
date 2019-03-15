package com.y.aop;

import com.alibaba.druid.util.StringUtils;
import com.y.common.exceptionhandler.UnifiedExceptionReturn;
import org.apache.tomcat.util.ExceptionUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author GCC.
 * Created on 2019/3/15.
 */
public aspect WebExceptionAspect {


    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void webPointcut() {}

    /**
     * 拦截web层异常，记录异常日志，并返回友好信息到前端
     * 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e 异常对象
     */
 /*   @AfterThrowing(value = "webPointcut()",throwing = "e")
    public UnifiedExceptionReturn handleThrowing(Exception e) {
        //不需要再记录ServiceException，因为在service异常切面中已经记录过
        UnifiedExceptionReturn u = new UnifiedExceptionReturn();
        return u;
    }*/

    /**
     * 将内容输出到浏览器
     *
     * @param content 输出内容
     */

    private void writeContent(String content) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("icop-content-type", "exception");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.print(content);
        writer.flush();
        writer.close();
    }
}
