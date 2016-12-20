package my.test.annotations;

import java.lang.annotation.*;

/**
 * TODO: Add doc
 *
 * Created by Nikita on 20.12.2016.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name();
    boolean lazyLoad() default false;
}
