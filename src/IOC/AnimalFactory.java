package IOC;

import java.lang.reflect.Proxy;

public class AnimalFactory {

	/***
	 * ��ȡ���󷽷�
	 * 
	 * @param obj
	 * @return
	 */

	// �����object��ָ��class���ɵ�һ������
	private static Object getAnimalBase(Object obj) {
		// ��ȡ�������
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new IOCHandler(AnnoInjection.getBean(obj)));
	}

	/***
	 * ��ȡ���󷽷�
	 * 
	 * @param <T>
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Object obj) {
		return (T) getAnimalBase(obj);
	}

	/***
	 * ��ȡ���󷽷�
	 * 
	 * @param <T>
	 * @param className
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(String className) {
		Object obj = null;
		try {
			obj = getAnimalBase(Class.forName(className).newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}

	/***
	 * ��ȡ���󷽷�
	 * 
	 * @param <T>
	 * @param clz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Class<?> clz) {
		Object obj = null;
		try {
			obj = getAnimalBase(clz.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}
}