package reflection.advanced;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String name = null;
}
