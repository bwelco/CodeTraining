package JavaAnnotation;

import java.lang.annotation.*;

/**
 * Created by bwelco on 2016/12/2.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BookName{
    public String getName() default "";
}
