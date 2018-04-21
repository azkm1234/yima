package interceptor;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.alibaba.fastjson.JSON;

import conf.ErrorCode;
import util.ResultTools;

@Aspect
@Component
@Lazy(value = false)
@Order(value = 1)
public class ControllerInterceptor {
	public static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);
	@Around(value = "execution(* controller.*.*(..))")
	public Object aroundController(ProceedingJoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		long startTime = System.currentTimeMillis();
		String method = joinPoint.getSignature().getName();
		String className = joinPoint.getClass().getName();
		int len = args.length;
		for (int i = len - 1; i >= 0; i--) {
			Object arg = args[i];
			if (arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult)arg;
				if (bindingResult.hasErrors()) {
					ObjectError objectError = bindingResult.getAllErrors().get(0);
					return recordLog(ErrorCode.ERRORCODE_MISSING_PARAM, 
							objectError.getDefaultMessage(),
							"",
							className,
							startTime);
				}
				break;
			}
			
		}
		try {
			logger.info("call params : " + Arrays.toString(args));
			Object result = joinPoint.proceed();
			logger.info("result : " + JSON.toJSONString(result));
			return recordLog(ErrorCode.ERRORCODE_SUCCESS, "", result, className, startTime);
		} catch (Throwable e) { 
			logger.error("excute controller method : " + method + " failed");
			
			return recordLog(ErrorCode.ERRORCODE_FAIL, e.getClass().getSimpleName() + " ->>> " + e.getMessage(), "", className, startTime);
		}
		
	}
	
	private String recordLog(ErrorCode code, String msg, Object value, String url, long startTime) {
		return ResultTools.returnAndRecordLog(code, msg, value, url, startTime);
	}
}
