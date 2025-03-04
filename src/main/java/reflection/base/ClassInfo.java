package reflection.base;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.IntFunction;

public class ClassInfo {

    private enum Test {
        A, B
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("reflection.base.ClassInfo is enum: " + ClassInfo.class.isEnum());
        System.out.println("Test is enum: " + Test.A.getClass().isEnum());
        System.out.println();
        IntFunction lambda = i -> i * i;
        System.out.println("reflection.base.ClassInfo is synthetic: " + ClassInfo.class.isSynthetic());
        System.out.println("lambda.getClass() is synthetic: " + lambda.getClass().isSynthetic());
        System.out.println();
        System.out.println("reflection.base.ClassInfo modifiers: " + ClassInfo.class.getModifiers());
        System.out.println("Test modifiers: " + Test.class.getModifiers());
        System.out.println("Test is private: " + java.lang.reflect.Modifier.isPrivate(Test.class.getModifiers()));
        System.out.println();
        System.out.println("reflection.base.ClassInfo is interface: " + ClassInfo.class.isInterface());
        System.out.println("List is interface: " + Class.forName("java.util.List").isInterface());
        System.out.println();
        System.out.println("reflection.base.ClassInfo is Serializable: " + Arrays.stream(ClassInfo.class.getInterfaces()).toList().contains(Serializable.class));
        System.out.println("ArrayList is Serializable: " + Arrays.stream(ArrayList.class.getInterfaces()).toList().contains(Serializable.class));
        //list instanceof Serializable
        System.out.println();
        //reflection.base.ClassInfo.class.newInstance()
        var constructor = ClassInfo.class.getDeclaredConstructor();
        var classInfo = constructor.newInstance();
        System.out.println(classInfo);
        //List.class.getAllChilds() //we can`t((
    }
}
