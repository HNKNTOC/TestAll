package my.test;

import my.test.data.DataObject;
import my.test.serialization.BytesSerialization;
import my.test.serialization.Serialization;
import my.test.serialization.XMLSerialization;

import java.io.File;

/**
 * TODO: Add doc
 * Created by Nikita on 16.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        goSerialization(new XMLSerialization(),"MyObject.xml");
        goSerialization(new BytesSerialization(),"MyObject.bin");
    }


    private static void goSerialization(Serialization serialization, String fileName){
        DataObject data = createDataObject();
        File file = createFile(fileName);
        serialization.write(data, file);
        DataObject readeResult = (DataObject) serialization.reade(file);
        System.out.println(readeResult);
    }

    private static File createFile(String fileName) {
        File file = new File("targetOutSerial/" + fileName);
        File parentFile = file.getParentFile();
        if (parentFile.mkdir()) {
            System.out.println("Failed create parent file.");
        }
        return file;
    }

    private static DataObject createDataObject() {
        DataObject data = new DataObject();
        data.setMyData("Hello world!");
        return data;
    }
}
