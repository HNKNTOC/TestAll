import goods.Camera;
import goods.Container;
import goods.Phone;
import goods.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        test5();
    }

    private static void test5() {
        Camera camera = new Camera("Camera 1");
        Camera camera2 = new Camera("Camera 2");
        Phone phone = new Phone("Phone 1");

        camera.setPrice(100);
        camera2.setPrice(200);

        System.out.println(camera.compareTo(camera2));
    }

    private static void test4() {
        ArrayList<Camera> cameras = new ArrayList<>();
        cameras.add(new Camera("Camera 1"));
        cameras.add(new Camera("Camera 2"));
        cameras.add(new Camera("Camera 3"));
        cameras.add(new Camera("Camera 4"));
        System.out.println(findOnlyOneType(cameras, new Camera("Camera 2")));
        //findOnlyOneType(cameras,new Product("Camera 2")); FAILED!!!
    }

    static <T extends Product<T>> boolean findOnlyOneType(List<T> all, T p) {
        for (Product product : all) {
            if(product.compareTo(p) == 0){
                return true;
            }
        }
        return false;
    }

    private static void test3() {
        ArrayList<Camera> cameras = new ArrayList<>();
        cameras.add(new Camera("Camera 1"));
        cameras.add(new Camera("Camera 2"));
        cameras.add(new Camera("Camera 3"));
        cameras.add(new Camera("Camera 4"));

        Container<Camera> container = new Container<Camera>();
        boolean out = container.find(cameras, new Camera("Camera 7"));
        System.out.println(out);
    }

    private static void test2() {
        //SomeType<?> - OK
        //SomeType - Failed use test method two.
        SomeType<?> someType = new SomeType();
        List<String> list = Collections.singletonList("Value");
        someType.test(list);
    }

    private static void test1() {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> strings = new ArrayList<>();

        arrayList = strings;
        arrayList.add(2); //Warning, not runtimeError
        System.out.println(arrayList);

        String s = (String) arrayList.get(0); //ClassCastException
        System.out.println(s);
    }
}
