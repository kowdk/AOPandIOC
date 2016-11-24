package AOPThreeMethods;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodPerformanceHandler implements InvocationHandler{
	private Object target;
	
	public MethodPerformanceHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object res = null;
		PerformanceMonitor.begin(target.getClass().getName() + '.' + method.getName());
		res = method.invoke(target, args);
		PerformanceMonitor.end();
		return res;
	}
}
