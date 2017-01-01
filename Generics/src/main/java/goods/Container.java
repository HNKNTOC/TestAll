package goods;

import java.util.List;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Container<T extends Product> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public boolean find(List<T> all, T p) {
        for (Product product : all) {
            if(product.compareTo(p) < 0){
                return true;
            }
        }
        return false;
    }
}
