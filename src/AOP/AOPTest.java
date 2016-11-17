package AOP;
import java.lang.reflect.Method;

public class AOPTest {

	public static void main(String[] args) {
		AnimalInterface dog = AnimalFactory.getAnimal(DogImpl.class, new AOPMethod() {
            // 这里写方法执行前的AOP切入方法
            public void before(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty")) {
                    System.err.println("成功拦截" + method.getName() + "方法, 该方法启动");
                }
            }
 
            // 这里系方法执行后的AOP切入方法
            public void after(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty"))
                    System.err.println("成功拦截" + method.getName() + "方法, 该方法结束");
 
            }
        });
		dog.say();
        dog.getProperty();
	}

}