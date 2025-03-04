package reflection.pro.autumn;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Autumn {

    private static Map<Class<?>, Object> services = new HashMap<>();
    private static Map<String, Method> gets = new HashMap<>();

    public static void runServer() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var reflections = new Reflections(
                new ConfigurationBuilder()
                        .forPackage("reflection.pro")
                        .setScanners(Scanners.TypesAnnotated)
        );
        var serviceClasses = reflections.getTypesAnnotatedWith(Service.class);
        for (var serviceClass : serviceClasses) {
            services.put(serviceClass, serviceClass.getConstructor().newInstance());
        }

        reflections = new Reflections("reflection.pro");
        for (var serviceClass : services.keySet()) {
            var service = services.get(serviceClass);
            for(var f:serviceClass.getDeclaredFields()) {
                if(f.isAnnotationPresent(AutoWired.class)) {
                    f.setAccessible(true);
                    System.out.println("Init " + f.getName() +" in " +serviceClass.getName());
                    if(f.getType().isInterface()) {
                        var types = reflections.getSubTypesOf(f.getType());
                        if(types.size() == 1) {
                            var clazz = types.iterator().next();
                            if(clazz.isAnnotationPresent(Service.class)) {
                                f.set(service, services.get(clazz));
                            } else {
                                //throw new IllegalState("@AutoWired Interface implementation must be @Service")
                            }
                        } else {
                            //throw new IllegalState("Only one interface implementation can exist")
                        }

                    } else {
                        f.set(service, services.get(f.getType()));
                    }

                }
            }
        }

        reflections = new Reflections(
                new ConfigurationBuilder()
                        .forPackage("reflection.pro")
                        .setScanners(Scanners.MethodsAnnotated)
        );
        var methods = reflections.getMethodsAnnotatedWith(Get.class);
        for (var method : methods) {
            gets.put(method.getName(), method);
        }
        var command = "";
        while (!Objects.equals(command, "exit")) {
            var s = new Scanner(System.in);
            var get = s.nextLine().toLowerCase(Locale.getDefault()).split(" ");
            command = get[0];
            var method = gets.get(command);
            Object result = null;
            if(method!=null) {
                var parameters= method.getParameterTypes();
                if(parameters.length == 0) {
                    result = method.invoke(services.get(method.getDeclaringClass()));
                }
                if(parameters.length == 1) {
                    if(parameters[0] == String.class)
                        result = method.invoke(
                                services.get(method.getDeclaringClass()),
                                get[1]
                        );
                    if(parameters[0] == Integer.TYPE)
                        result = method.invoke(
                            services.get(method.getDeclaringClass()),
                            Integer.parseInt(get[1])
                    );
                }
                if(parameters.length == 2) {
                    if((parameters[1] == Integer.TYPE) && (parameters[2] == Integer.TYPE)) {
                        result = method.invoke(
                                services.get(method.getDeclaringClass()),
                                Integer.parseInt(get[1]),
                                Integer.parseInt(get[1])
                        );
                    }
                }
            }
            System.out.println(result);
        }
    }
}
