package com.y.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.y.common.GlobalVar;
import com.y.util.NetUtil;
import com.y.vo.JsonOut;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.io.IOException;

import static com.y.common.CodeMsg.CODE_1000;

/**
 * @author GCC.
 * Created on 2019/4/28.
 */
@Configuration
public class Filter implements javax.servlet.Filter {
    @Value("${server.servlet.context-path}")
    private String path;

    @Autowired
    private ObjectMapper mapper;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        String ip= NetUtil.getIpAddress(httpRequest);
        httpRequest.setAttribute(GlobalVar.IP, ip);
        //url以**不用验证
        boolean isDruid = url.startsWith(path+ "/druid");
        if(isDruid){
            chain.doFilter(httpRequest,httpResponse);
            return;
        }

        //版本号
        String version = httpRequest.getHeader("version");
        //用户id
        String uid = httpRequest.getHeader("uid");
        //0 网页，1 app
        String type = httpRequest.getHeader("type");
        if(StringUtils.isBlank(version) || StringUtils.isBlank(uid)
                || StringUtils.isBlank(type)){
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            httpResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpResponse.getWriter().write(mapper.writeValueAsString(new JsonOut(CODE_1000.getCode(),CODE_1000.getMsg())));
            return;
        }
        chain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {

    }
}
