package AOPThreeMethods;

public class ForumServiceImplCoupling implements ForumService{

	@SuppressWarnings("static-access")
	@Override
	public void removeTopic(int topicId) {
		PerformanceMonitor.begin("removeTopic"); // 开始和结束的代码糅杂在业务代码中，难以剥离
		System.out.println("remove topic ： " + topicId);
		try{
			Thread.currentThread().sleep(20);
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			PerformanceMonitor.end(); // 开始和结束的代码糅杂在业务代码中，难以剥离
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void removeForum(int id) {
		PerformanceMonitor.begin("removeForum");
		System.out.println("remove forum ： " + id);
		try{
			Thread.currentThread().sleep(40);
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			PerformanceMonitor.end();
		}
	}

}
