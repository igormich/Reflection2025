package reflection.base;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.reflect.Modifier.STATIC;

public class MethodsUsage {

    public static void main(String[] args) {
        var listClass = List.class;
        var methodsZeroArg = Arrays.stream(listClass.getMethods())
                .filter(m -> m.getParameterCount() == 0 && !Modifier.isStatic(m.getModifiers()))
                .toList();
        var list = Arrays.asList(1, 2, 3, 4, 5);
        for (var method : methodsZeroArg) {
            System.out.println("invoke " + method.getName());
            try {
                //list.method()
                System.out.println(method.invoke(list));
            } catch (Exception e) {
                System.out.println("fail with " + e.getCause());
            }
        }

        System.out.println();
        System.out.println();

        var methodsIntArg = Arrays.stream(listClass.getMethods())
                .filter(m -> m.getParameterCount() == 1 &&
                        !Modifier.isStatic(m.getModifiers()) &&
                        m.getParameterTypes()[0] == Integer.TYPE
                ).toList();
        for (var method : methodsIntArg) {
            System.out.println("invoke " + method.getName());
            try {
                System.out.println(method.invoke(list, 1));
            } catch (Exception e) {
                System.out.println("fail with " + e.getCause());
            }
        }
    }
}
