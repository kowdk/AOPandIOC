package IOC;

import java.lang.reflect.Proxy;

public class AnimalFactory {

	/***
	 * 获取对象方法
	 * 
	 * @param obj
	 * @return
	 */

	// 这里的object是指定class生成的一个对象，
	private static Object getAnimalBase(Object obj) {
		// 获取代理对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new IOCHandler(AnnoInjection.getBean(obj)));
	}

	/***
	 * 获取对象方法
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
	 * 获取对象方法
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
	 * 获取对象方法
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