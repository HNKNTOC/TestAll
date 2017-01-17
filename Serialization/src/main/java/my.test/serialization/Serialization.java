package my.test.serialization;

import java.io.File;

/**
 * TODO: Add doc
 * Created by Nikita on 16.01.2017.
 */
public abstract class Serialization {
    private final String type;

    Serialization(String type) {
        this.type = type;
    }

    public void write(Object obj, File file){
        System.out.println("====== Write in "+ type +" File:"+file.getName()+" ======");
        goWrite(obj,file);
        System.out.println("File write: "+file.length()+" bytes.");
        System.out.println("==================");
    }

    public Object reade(File file){
        System.out.println("====== Reade of "+ type +" File:"+file.getName()+" ======");
        Object obj = goReade(file);
        System.out.println("==================");
        return obj;
    }

    protected abstract Object goReade(File file);

    protected abstract void goWrite(Object obj, File file);

}
