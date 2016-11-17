package AOP;
import java.lang.reflect.Proxy;

import AOP.AOPHandler;
import AOP.AOPMethod;
import IOC.AnnoInjection;

public class AnimalFactory {

	/***
	 * 获取对象方法
	 * 
	 * @param obj
	 * @return
	 */
	private static Object getAnimalBase(Object obj, AOPMethod m) {
		// 获取代理对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new AOPHandler(obj, m));
	}

	/***
	 * 获取对象方法
	 * 
	 * @param <T>
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Object obj, AOPMethod m) {
		return (T) getAnimalBase(obj, m);
	}

	/***
	 * 获取对象方法
	 * 
	 * @param <T>
	 * @param className
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(String className, AOPMethod m) {
		Object obj = null;
		try {
			obj = getAnimalBase(Class.forName(className).newInstance(), m);
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
	public static <T> T getAnimal(Class<?> clz, AOPMethod m) {
		Object obj = null;
		try {
			obj = getAnimalBase(clz.newInstance(), m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}
}