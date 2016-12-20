package my.test;

import my.test.annotations.Service;

/**
 * TODO: Add doc
 * Created by Nikita on 21.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }

    private static void inspectService(Class<?> service) {
        if (!service.isAnnotationPresent(Service.class)) {
            System.out.println(
                    "Failed "+service+" not found annotation "+Service.class);
            return;
        }
        Service ann = service.getAnnotation(Service.class);
        System.out.println(ann.name());
    }
}
