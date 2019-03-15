package com.y.aop;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.HashMap;

/**
 * Web层日志切面
 */
@Aspect
@Order(5)
@Component
@Log4j2
public class WebLogAspect {

	private static final ThreadLocal<HashMap<String, Object>> INFO = new ThreadLocal<>();

	public static ThreadLocal<HashMap<String, Object>> getInfo() {
		return INFO;
	}

	@Pointcut("execution(public * com.y.controller..*.*(..))")
	public void webLog() {
	}
	
	@Pointcut("execution(public * com.y.common.exceptionhandler.RestExceptionHandler*(..))")
    public void exceptionLog() {
    }

}
