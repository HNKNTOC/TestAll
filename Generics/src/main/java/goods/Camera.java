package goods;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Camera extends Product {
    private int pix;

    public Camera(String name) {
        super(name);
    }

    public int getPix() {
        return pix;
    }

    public void setPix(int pix) {
        this.pix = pix;
    }
}
