import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.reflect.Modifier.STATIC;

public class ListMethods {

    public static void main(String[] args) {
        var arrayListClass = ArrayList.class;
        var methods = arrayListClass.getMethods();//all visible
        System.out.println("Public methods count in ArrayList " + methods.length);
        for(var field : methods) {
            System.out.println(field);
        }
        System.out.println();
        methods = arrayListClass.getDeclaredMethods();
        System.out.println("Declared methods count in ArrayList " + methods.length);
        for(var field : methods) {
            System.out.println(field);
        }
        System.out.println();
        var staticMethods = Arrays.stream(methods).filter(m->Modifier.isStatic(m.getModifiers())).toList();
        System.out.println("Declared static methods count in ArrayList " + staticMethods.size());
        for(var field : staticMethods) {
            System.out.println(field);
        }
    }
}
