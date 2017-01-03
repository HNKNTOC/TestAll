package goods;

import java.util.Objects;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Phone extends Product<Phone> {
    private String model;

    public Phone(String name) {
        super(name);
    }

    @Override
    boolean subCompareTo(Phone phone) {
        return Objects.equals(model, phone.getModel());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
