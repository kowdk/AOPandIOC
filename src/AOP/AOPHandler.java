package AOP;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPHandler implements InvocationHandler {
	// �������
	private Object obj; // obj����Ҫ���������������
	private AOPMethod aop;
	
	public AOPHandler(Object obj, AOPMethod aop) {
		this.obj = obj;
		this.aop = aop;
	}

	/**
	 * ����������Զ�����,Java��̬������� �ᴫ�������Ǹ�����
	 * 
	 * @param Object
	 *            proxy �������Ľӿ�,��ͬ�ڶ���
	 * @param Method
	 *            method �����÷���
	 * @param Object[]
	 *            args �������� ����ʹ��invokeʱʹ��proxy��Ϊ�������ʱ,��Ϊ�������Ľӿ�,��ͬ�ڶ���
	 *            ���ִ������������ӿڣ��������������
	 **/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ��������ֵ
		Object ret = null;
		
		/*System.err.println("ִ�з���:" + method.getName() + ",��������Ϊ:");
		for (Class<?> type : method.getParameterTypes())
			System.err.println(type.getName());
		System.err.println("������������:" + method.getReturnType().getName());*/
		
		aop.before(proxy, method, args);
		
		// ������÷���
		ret = method.invoke(obj, args);
		
		aop.after(proxy, method, args);
		
		//System.err.println("����ִ�н���");
		
		// ���ط�����÷����ķ���ֵ
		return ret;
	}
}