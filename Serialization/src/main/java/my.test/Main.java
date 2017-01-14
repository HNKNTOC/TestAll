package my.test;

import java.io.*;

/**
 * This example for Serialization in Java.
 */
public class Main {
    public static void main(String[] args) {
        DataObject data = new DataObject();
        data.setMyData("Hello world!");
        File file = new File("store.bin");
        save(data, file);
        DataObject readeResult = reade(file);
        System.out.println(readeResult);

    }

    public static DataObject reade(File file){
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

    private static void save(Serializable obj, File file) {


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

        System.out.println("File save: "+file.length()+" bytes.");
    }
}
