package interceptor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import serviceinterface.SessionService;
import vo.SessionVo;

@Aspect
@Component
@Lazy(false)
@Order(value = 2)
public class SessionInterceptor {
	@Autowired
	private SessionService sessionService;
	@Around(value = "execution(* controller.*.add*(..)) || "
			+ "execution(* controller.*.update*(..)) || "
			+ "execution(* controller.*.remove*(..)) "
			+ "execution(* controller.MineController.*(..)")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		int len = args.length;
		for (int i = len - 1; i >= 0; i--) {
			Object arg = args[i];
			if (arg instanceof SessionVo) {
				SessionVo session = (SessionVo)arg;
				String sessionId = session.getSessionId();
				if (this.sessionService.containsKey(sessionId)) {
					Object object = joinPoint.proceed();
					return object;
				}
				break;
			}
		}
		throw new Exception("Äú»¹Î´µÇÂ¼£¡");
	}
}
