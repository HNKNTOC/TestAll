package my.test.serialization;

import com.google.gson.Gson;
import my.test.data.DataObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This example for serialization object in JSON.
 */
public class JSONSerialization extends Serialization {

    private Gson gson = new Gson();
    /**
     * GSON need know the class is object for goReade.
     */
    private Class<?> classOfT;

    public JSONSerialization() {
        super("JSON");
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public Class<?> getClassOfT() {
        return classOfT;
    }

    public void setClassOfT(Class<?> classOfT) {
        this.classOfT = classOfT;
    }

    @Override
    protected void goWrite(Object obj, File file) {
        String json = gson.toJson(obj);
        System.out.println("goWrite:" + json);
        final Path path = Paths.get(file.getPath());
        try {
            Files.write(path, json.getBytes());
            classOfT = obj.getClass();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object goReade(File file) {
        final Path path = Paths.get(file.getPath());
        try {
            byte[] bytes = Files.readAllBytes(path);
            String json = new String(bytes);
            System.out.println("goReade:" + json);
            return gson.fromJson(json, classOfT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
