package IOC;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoInjection {
 
	// ���������dogImpl����󣬱����������Ժͷ�����һ��������ע�⣬��ע��ע���ֵ
    public static Object getBean(Object obj) {
        try {
            // ���������
            Field f[] = obj.getClass().getDeclaredFields();
            // ��������
            for (Field ff : f) {
                // ��������ϵ�ע��
                Annotate s = ff.getAnnotation(Annotate.class);
                if (s != null) {
                    System.err.println("ע��" + ff.getName() + "����, ֵ��" + s.value());
                    // �������public set����,���Ϊ���ʼ���private,��ô����ֱ��ʹ�����Ե�set(obj,
                    // value);
                    obj.getClass()
                            .getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
                                    new Class[] { String.class })
                            .invoke(obj, s.value());
                }
            }
            // ������з���
            Method m[] = obj.getClass().getDeclaredMethods();
            for (Method mm : m) {
                // ��÷���ע��
            	Annotate s = mm.getAnnotation(Annotate.class);
                if (s != null) {
                    System.err.println("ע��" + mm.getName() + "������ֵ��" + s.property());
                    mm.invoke(obj, s.property());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}