package interceptor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import serviceinterface.SessionService;

@Aspect
@Component
@Lazy(false)
@Order(value = 2)
public class SessionInterceptor {
	@Autowired
	private SessionService sessionService;
	@Around(value = "execution(* controller.*.add*(..)) || " + 
		"execution(* controller.*.update*(..)) || " + 
		"execution(* controller.*.remove*(..))")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		if (args.length == 2 && args[1] instanceof String) {
			String sessionId = (String)args[1];
			if (this.sessionService.containsKey(sessionId)) {
				Object object = joinPoint.proceed();
				return object;
			} else {
				throw new Exception("sessionId is not corrected");
			}
		} else {
			return joinPoint.proceed();
		}
	}
}
