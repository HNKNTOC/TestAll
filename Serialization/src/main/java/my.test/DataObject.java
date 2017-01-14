package my.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * TODO: Add doc
 * Created by Nikita on 14.01.2017.
 */
public class DataObject extends NonSerializable implements Serializable {
    private int number = 55;
    private String string = "My test string.";
    private transient String[] strings = {
            "String 1",
            "String 2",
            "String 3"
    };
    private CustomObject customObject = new CustomObject();

    public DataObject() {
        System.out.println("Create DataObject.");
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Call writeObject()");
        out.defaultWriteObject();
        out.writeObject(getMyData());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Call readObject()");
        in.defaultReadObject();
        String myData = (String) in.readObject();
        setMyData(myData);
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "number=" + number +
                ", string='" + string + '\'' +
                ", strings=" + Arrays.toString(strings) +
                ", customObject=" + customObject +
                "} " + super.toString();
    }
}
