package my.test;

import my.test.annotations.Init;
import my.test.annotations.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Add doc
 * Created by Nikita on 21.12.2016.
 */
public class Main {

    private static Map<String, Object> hashMap = new HashMap<>();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        inspectService(classForName("my.test.LazyService"));
        inspectService(classForName("my.test.SimpleService"));
        inspectService(classForName("java.lang.String"));
        System.out.println(hashMap);
        System.out.println("===== invokeInit =====");
        invokeInit(hashMap);
    }

    private static Class<?> classForName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void inspectService(Class<?> service) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("=================");
        if (service == null) {
            System.out.println("Failed service must not be null.");
            return;
        }
        if (!service.isAnnotationPresent(Service.class)) {
            System.out.println(
                    "Failed " + service + " not found annotation " + Service.class);
            return;
        }
        printNameService(service);

        showMethodWithAnnotation(service);

        Object o = service.newInstance();
        hashMap.put(o.getClass().getName(), o);
    }


    public static void invokeInit(Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
        for (Object obj : map.values()) {
            if (obj.getClass().getAnnotation(Service.class).lazyLoad()) {
                for (Method method : findMethodWithAnnotation(
                        obj.getClass().getDeclaredMethods())) {
                    invoke(obj, method);
                }
            }
        }
    }

    private static void invoke(Object o, Method method) throws IllegalAccessException, InvocationTargetException {
        try {
            method.invoke(o);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Init annotation = method.getAnnotation(Init.class);
            if (annotation.suppressException()) {
                System.err.println("Failed " + e);
            } else {
                e.printStackTrace();
            }
        }
    }

    private static void showMethodWithAnnotation(Class<?> service) {
        Method[] methods = service.getDeclaredMethods();
        for (Method method : findMethodWithAnnotation(methods)) {
            System.out.println("Method present annotation " + method.getName());
        }
    }

    private static ArrayList<Method> findMethodWithAnnotation(Method[] methods) {
        ArrayList<Method> result = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Init.class)) {
                result.add(method);
            }
        }
        return result;
    }

    private static void printNameService(Class<?> service) {
        Service ann = service.getAnnotation(Service.class);
        System.out.println(ann.name());
    }
}
