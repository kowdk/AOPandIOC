package AOPThreeMethods;

public class TestCglib {
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		
		ForumServiceImpl fs = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
		fs.removeForum(111);
		fs.removeTopic(222);
	}
}
