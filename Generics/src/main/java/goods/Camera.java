package goods;

/**
 * TODO: Add doc
 * Created by Nikita on 02.01.2017.
 */
public class Camera extends Product<Camera> {
    private int pix;

    public Camera(String name) {
        super(name);
    }

    @Override
    boolean subCompareTo(Camera camera) {
        return pix == camera.getPix();
    }

    public int getPix() {
        return pix;
    }

    public void setPix(int pix) {
        this.pix = pix;
    }
}
