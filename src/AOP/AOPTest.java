package AOP;
import java.lang.reflect.Method;

public class AOPTest {

	public static void main(String[] args) {
		AnimalInterface dog = AnimalFactory.getAnimal(DogImpl.class, new AOPMethod() {
            // ����д����ִ��ǰ��AOP���뷽��
            public void before(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty")) {
                    System.err.println("�ɹ�����" + method.getName() + "����, �÷�������");
                }
            }
 
            // ����ϵ����ִ�к��AOP���뷽��
            public void after(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty"))
                    System.err.println("�ɹ�����" + method.getName() + "����, �÷�������");
 
            }
        });
		dog.say();
        dog.getProperty();
	}

}