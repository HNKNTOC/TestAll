package goods;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Product implements Comparable<Product> {
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

    @Override
    public int compareTo(Product o) {
        return name.compareTo(o.getName());
    }
}
