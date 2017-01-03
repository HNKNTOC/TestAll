package goods;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public abstract class Product<T extends Product<T>> implements Comparable<T> {
    private String name;
    private int price;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    abstract boolean subCompareTo(T p);

    @Override
    public int compareTo(T product) {
        if(!subCompareTo(product)) return -1;
        return price - product.getPrice();
    }
}
