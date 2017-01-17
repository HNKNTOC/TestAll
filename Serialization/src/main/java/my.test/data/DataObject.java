package my.test.data;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example for serialization.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "dataObject")
public class DataObject extends NonSerializable implements Serializable {
    @XmlAttribute
    private int number = 55;
    @XmlElement(name = "string")
    private String string = "My test string.";

    @XmlElementWrapper(name = "strings")
    @XmlElement(name = "string")
    private String[] strings = {
            "String 1",
            "String 2",
            "String 3"
    };
    @XmlElement
    private CustomObject customObject = new CustomObject();
    @XmlElement
    @XmlElementWrapper(name = "elementCustomObject")
    private List<CustomObject> customObjects = new ArrayList<>();

    public DataObject() {
        System.out.println("Create DataObject.");
        customObjects.add(new CustomObject());
        customObjects.add(new CustomObject(true));
        customObjects.add(new CustomObject());
        customObjects.add(new CustomObject(true));
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }

    public CustomObject getCustomObject() {
        return customObject;
    }

    public String[] getStrings() {
        return strings;
    }

    public List<CustomObject> getCustomObjects() {
        return customObjects;
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
