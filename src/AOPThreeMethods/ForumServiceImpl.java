package AOPThreeMethods;

/**
 * 使用AOP剥离后的纯粹的业务代码
 * @author xutao
 *
 */
public class ForumServiceImpl implements ForumService {
	
	@SuppressWarnings("static-access")
	@Override
	public void removeTopic(int topicId) {
		System.out.println("remove topic ： " + topicId);
		try{
			Thread.currentThread().sleep(20);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void removeForum(int id) {
		System.out.println("remove forum ： " + id);
		try{
			Thread.currentThread().sleep(40);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
