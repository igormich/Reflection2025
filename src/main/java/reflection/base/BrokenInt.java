package reflection.base;

import java.util.Arrays;

public class BrokenInt {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        var integerCache = Class.forName("java.lang.Integer$IntegerCache");
        var cacheField = integerCache.getDeclaredField("cache");
        cacheField.setAccessible(true);
        //on JVM version 9+ need add  arg: --add-opens java.base/java.lang=ALL-UNNAMED
        Integer[] cache = (Integer[]) cacheField.get(null); //static field - no object need
        Arrays.fill(cache, 42);
        //cacheField.set(null, new Integer(?));







        Integer zero = 0;
        Integer ten = 10;
        System.out.println(zero);
        System.out.println(zero + ten);
        System.out.println(zero + 10);
    }
}