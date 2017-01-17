package my.test.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * TODO: Add doc
 * Created by Nikita on 14.01.2017.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "customObject")
public class CustomObject implements Externalizable {
    @XmlElement
    private boolean enable;

    public CustomObject() {
        System.out.println("Create CustomObject.");
    }

    public CustomObject(boolean enable) {
        this();
        this.enable = enable;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(enable);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        enable = in.readBoolean();
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "aBoolean=" + enable +
                '}';
    }
}
