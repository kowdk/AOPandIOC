package IOC;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IOCHandler implements InvocationHandler {
	// �������
	private Object obj; // obj����Ҫ���������������
	
	public IOCHandler(Object obj) {
		this.obj = obj;
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
		
		// ������÷���
		ret = method.invoke(obj, args);
		
		//System.err.println("����ִ�н���");
		
		// ���ط�����÷����ķ���ֵ
		return ret;
	}
}