package IOC;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoInjection {
 
	// 遍历传入的dogImpl类对象，遍历它的属性和方法，一旦发现有注解，就注入注解的值
    public static Object getBean(Object obj) {
        try {
            // 获得类属性
            Field f[] = obj.getClass().getDeclaredFields();
            // 遍历属性
            for (Field ff : f) {
                // 获得属性上的注解
                Annotate s = ff.getAnnotation(Annotate.class);
                if (s != null) {
                    System.err.println("注入" + ff.getName() + "属性, 值：" + s.value());
                    // 反射调用public set方法,如果为访问级别private,那么可以直接使用属性的set(obj,
                    // value);
                    obj.getClass()
                            .getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
                                    new Class[] { String.class })
                            .invoke(obj, s.value());
                }
            }
            // 获得所有方法
            Method m[] = obj.getClass().getDeclaredMethods();
            for (Method mm : m) {
                // 获得方法注解
            	Annotate s = mm.getAnnotation(Annotate.class);
                if (s != null) {
                    System.err.println("注入" + mm.getName() + "方法，值：" + s.property());
                    mm.invoke(obj, s.property());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}