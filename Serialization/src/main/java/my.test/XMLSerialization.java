package my.test;

import com.sun.xml.internal.ws.util.Pool;
import my.test.data.CustomObject;
import my.test.data.DataObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * This example for serialization object in XML.
 */
public class XMLSerialization extends Serialization {

    private final static Class[] CLASSES = {
            DataObject.class,
            CustomObject.class
    };

    private static JAXBContext CONTEXT;

    XMLSerialization() {
        super("XML");
        try {
            CONTEXT = JAXBContext.newInstance(CLASSES);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void goWrite(Object obj, File file) {
        if (obj instanceof DataObject) {
            DataObject dataObject = (DataObject) obj;
            try {
                Marshaller marshaller = CONTEXT.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                marshaller.marshal(dataObject, file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed " + obj + " is not DataObject");
        }

    }

    @Override
    protected Object goReade(File file) {
        try {
            Unmarshaller unmarshaller = CONTEXT.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
