package epsilongtmyon.app.common.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import org.jboss.logging.Logger;

import epsilongtmyon.app.common.interceptor.annotation.Logging;

// CDI のインターセプター

@Interceptor
@Logging
@Priority(Interceptor.Priority.APPLICATION + 1)
public class LoggingInterceptor {

	@Inject
	Logger logger;

	@AroundInvoke
	Object logInvocation(InvocationContext context) throws Exception {
		String name = context.getTarget().getClass().getName();
		Method method = context.getMethod();
		Object[] parameters = context.getParameters();

		try {
			logger.infov("begin: {0} {1} {2}", name, method.getName(), Arrays.toString(parameters));
			Object ret = context.proceed();
			logger.infov("end: {0} {1} {2}", name, method.getName(), ret);
			return ret;
		} catch (Exception e) {
			logger.errorv(e, "exception: {0} {1}", name, method.getName());
			throw e;
		}
	}
}
