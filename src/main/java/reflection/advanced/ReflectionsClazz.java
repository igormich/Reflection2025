package reflection.advanced;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

public class ReflectionsClazz {

    private static HashMap<Class<? extends BotPart>, BotPart> bots = new HashMap();
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("reflection.advanced");


        var botsClazz = reflections.getSubTypesOf(BotPart.class);

        System.out.println("Найдено реализаций: " + bots.size());
        for (var clazz : botsClazz) {
            System.out.println(clazz.getName());
        }
        System.out.println();
        System.out.println();
        for (Class<? extends BotPart> clazz : botsClazz) {
            bots.put(clazz, clazz.getDeclaredConstructor().newInstance());
        }
        System.out.println();
        for (var bot : bots.values()) {
            bot.init();
        }
    }
}
