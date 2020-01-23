package first.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("execution(public * first.web.controller.*.*(..))")
	public void before(JoinPoint point) throws Throwable {
		String msg = point.getTarget().getClass().getSimpleName() + "." + point.getSignature().getName() + " START.";
		
		Object params[] = point.getArgs();
		if(params.length > 0) {
			String args = "";
			for(Object p : params) {
				if(p != null && p.getClass() != null && (p.getClass() == Integer.class || p.getClass() == String.class)) {
					if(args.length() > 0)
						args += ", ";
					args += p;
				}
			}
			if(args.length() > 0)
				msg += " .. parameter : " + args;
		}		
		logger.debug(msg);
	}
	
	@After("execution(public * first.web.controller.*.*(..))")
	public void after(JoinPoint point) throws Throwable {
		logger.debug(point.getTarget().getClass().getSimpleName() + "." + point.getSignature().getName() + " END.");
	}

}