package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 指定注解生效的时间
@Target(ElementType.METHOD) // 指定注解生效的位置
public @interface NeedTest {
	boolean value() default true;
}
