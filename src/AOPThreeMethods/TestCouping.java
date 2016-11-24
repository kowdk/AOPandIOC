package AOPThreeMethods;

public class TestCouping {
	public static void main(String[] args) {
		ForumServiceImplCoupling fs = new ForumServiceImplCoupling();
		
		fs.removeForum(100);
		fs.removeTopic(200);
	}
}
