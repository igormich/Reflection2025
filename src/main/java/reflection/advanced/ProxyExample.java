package reflection.advanced;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProxyExample implements InvocationHandler {
    public static void main(String[] args) {


        List<String> proxyList = (List<String>) Proxy.newProxyInstance(
                ProxyExample.class.getClassLoader(),
                new Class<?>[]{List.class},// interfaces
                new ProxyExample()// Proxy
        );
        proxyList.add("Hello");
        proxyList.add("World");
        System.out.println("list size: " + proxyList.size());
        proxyList.clear();
    }

    private final List<String> realList= new ArrayList<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("call method: " + method.getName() +
                " with args " + Arrays.toString(args));
        Object result = method.invoke(realList, args);
        System.out.println("method " + method.getName() + " return " + result);
        return result;
    }
}