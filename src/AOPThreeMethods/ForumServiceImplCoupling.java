package AOPThreeMethods;

public class ForumServiceImplCoupling implements ForumService{

	@SuppressWarnings("static-access")
	@Override
	public void removeTopic(int topicId) {
		PerformanceMonitor.begin("removeTopic"); // ��ʼ�ͽ����Ĵ���������ҵ������У����԰���
		System.out.println("remove topic �� " + topicId);
		try{
			Thread.currentThread().sleep(20);
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			PerformanceMonitor.end(); // ��ʼ�ͽ����Ĵ���������ҵ������У����԰���
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void removeForum(int id) {
		PerformanceMonitor.begin("removeForum");
		System.out.println("remove forum �� " + id);
		try{
			Thread.currentThread().sleep(40);
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			PerformanceMonitor.end();
		}
	}

}
