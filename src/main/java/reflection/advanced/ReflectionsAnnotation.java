package reflection.advanced;


import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

//@MyAnnotation
public class ReflectionsAnnotation {

    @MyAnnotation
    public void annotatedMethod(){

    }

    public void simpleMethod(){

    }

    @MyAnnotation
    public static void annotatedStaticMethod(){

    }
    @MyAnnotation
    private void annotatedPrivateMethod(){

    }
    public static class Temp {
        @MyAnnotation
        public void methodInTemp(){

        }
    }
    public static void main(String[] args) {
        var  reflections = new Reflections(
                new ConfigurationBuilder()
                        .forPackage("reflection.advanced")
                        .setScanners(Scanners.MethodsAnnotated)
        );
        var methods = reflections.getMethodsAnnotatedWith(MyAnnotation.class);
        for (var method : methods) {
            System.out.println(method.getName());
        }

    }
}
