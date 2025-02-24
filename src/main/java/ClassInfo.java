import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ClassInfo {

    private enum Test {
        A, B
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("ClassInfo is enum: " + ClassInfo.class.isEnum());
        System.out.println("Test is enum: " + Test.class.isEnum());
        System.out.println();
        IntFunction lambda = i->i*i;
        System.out.println("ClassInfo is synthetic: " + ClassInfo.class.isSynthetic());
        System.out.println("lambda.getClass() is synthetic: " + lambda.getClass().isSynthetic());
        System.out.println();
        System.out.println("ClassInfo modifiers: " + ClassInfo.class.getModifiers());
        System.out.println("Test modifiers: " + Test.class.getModifiers());
        System.out.println("Test is private: " + java.lang.reflect.Modifier.isPrivate(Test.class.getModifiers()));
        System.out.println();
        System.out.println("ClassInfo is interface: " + ClassInfo.class.isInterface());
        System.out.println("List is interface: " + List.class.isInterface());
        System.out.println();
        System.out.println("ClassInfo is Serializable: " + Arrays.stream(ClassInfo.class.getInterfaces()).toList().contains(Serializable.class));
        System.out.println("ArrayList is Serializable: " + Arrays.stream(ArrayList.class.getInterfaces()).toList().contains(Serializable.class));
        //list is Serializable
        System.out.println();
        //ClassInfo.class.newInstance()
        var classInfo = ClassInfo.class.getDeclaredConstructor().newInstance();
        System.out.println(classInfo);
        //List.class.getAllChilds() //we can`t((
    }
}
