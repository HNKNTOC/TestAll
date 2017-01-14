package my.test;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * TODO: Add doc
 * Created by Nikita on 14.01.2017.
 */
public class CustomObject implements Externalizable {
    private transient boolean aBoolean = true;

    public CustomObject() {
        System.out.println("Create CustomObject.");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(aBoolean);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        aBoolean = in.readBoolean();
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "aBoolean=" + aBoolean +
                '}';
    }
}
