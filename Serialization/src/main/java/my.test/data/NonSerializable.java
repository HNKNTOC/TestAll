package my.test.data;

/**
 * TODO: Add doc
 * Created by Nikita on 14.01.2017.
 */
public class NonSerializable {
    private String myData = "";

    String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }

    NonSerializable() {
        System.out.println("Create NonSerializable.");
    }
}
