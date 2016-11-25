package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // ָ��ע����Ч��ʱ��
@Target(ElementType.METHOD) // ָ��ע����Ч��λ��
public @interface NeedTest {
	boolean value() default true;
}
