package my.test;

/**
 * TODO: Add doc
 * Created by Nikita on 14.01.2017.
 */
public class NonSerializable {
    private String myData = "";

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }

    public NonSerializable() {
        System.out.println("Create NonSerializable.");
    }
}
