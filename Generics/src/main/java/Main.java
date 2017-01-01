import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
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
