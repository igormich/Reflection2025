import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.reflect.Modifier.STATIC;

public class ListFields {

    public static void main(String[] args) {
        var arrayListClass = ArrayList.class;
        var fields = arrayListClass.getFields();
        System.out.println("Public fields count in ArrayList " + fields.length);
        for(var field : fields) {
            System.out.println(field);
        }
        System.out.println();
        fields = arrayListClass.getDeclaredFields();
        System.out.println("Declared fields count in ArrayList " + fields.length);
        for(var field : fields) {
            System.out.println(field);
        }
        System.out.println();
        var staticFields = Arrays.stream(fields).filter(f-> Modifier.isStatic(f.getModifiers())).toList();
        System.out.println("Declared static fields count in ArrayList " + staticFields.size());
        for(var field : staticFields) {
            System.out.println(field);
        }
    }
}
