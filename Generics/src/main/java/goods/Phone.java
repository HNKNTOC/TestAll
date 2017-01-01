package goods;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Phone extends Product {
    private String model;

    public Phone(String name) {
        super(name);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
