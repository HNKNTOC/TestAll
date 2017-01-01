import java.util.Collection;
import java.util.List;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class SomeType<T> {

    public <E> void test(Collection<E> collection){
        System.out.println("Use test 1");
        for (E e : collection) {
            System.out.println(e);
        }
    }

    public void test(List<Integer> integerList){
        System.out.println("Use test 2");
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }

}
