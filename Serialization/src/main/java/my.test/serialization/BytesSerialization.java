package my.test.serialization;

import my.test.data.DataObject;

import java.io.*;

/**
 * This example for serialization object in bytes.
 */
public class BytesSerialization extends Serialization {
    public BytesSerialization() {
        super("Bytes");
    }

    @Override
    protected void goWrite(Object obj, File file) {
        if(obj instanceof Serializable){
            Serializable serial = (Serializable) obj;
            writeBytes(serial,file);
        }else {
            System.out.println("Failed. Object "+obj+" not implements Serializable.");
        }
    }

    @Override
    protected Object goReade(File file) {
        return readeBytes(file);
    }

    private static DataObject readeBytes(File file){
        try (
                FileInputStream fi =
                        new FileInputStream(file);
                ObjectInputStream si =
                        new ObjectInputStream(fi)
        ) {
            return (DataObject) si.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("reade: return null.");
        return null;
    }

    private static void writeBytes(Serializable obj, File file) {


        try (
                FileOutputStream fo =
                        new FileOutputStream(file);
                ObjectOutputStream so =
                        new ObjectOutputStream(fo)
        ) {
            so.writeObject(obj);
            so.flush();
            so.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
