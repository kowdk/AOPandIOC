package AOPThreeMethods;

import java.lang.reflect.Proxy;

public class TestAOP {
	public static void main(String[] args) {
		ForumService target = new ForumServiceImpl();
		MethodPerformanceHandler handler = new MethodPerformanceHandler(target);
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
		proxy.removeForum(111);
		proxy.removeTopic(222);
	}
}
