package top.cfish.thread.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: isisiwish
 * @date: 2019/01/18
 * @time: 9:33
 */

/**
 * 使用该注解标注的类为线程不安全类
 * 该注解编译后不生效
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadNotSafe
{
    String value() default "";
}
