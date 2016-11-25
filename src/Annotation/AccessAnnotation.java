package Annotation;

import java.lang.reflect.Method;

public class AccessAnnotation {
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class clazz = BasicService.class;
		Method[] ms = clazz.getDeclaredMethods();
		for(Method m : ms) {
			NeedTest nt = m.getAnnotation(NeedTest.class);
			if(nt != null) {
				if(nt.value()) {
					System.out.println(m.getName() + "() need test...");
				} else {
					System.out.println(m.getName() + "() do not need test...");
				}
			}
		}
		
	}
}
