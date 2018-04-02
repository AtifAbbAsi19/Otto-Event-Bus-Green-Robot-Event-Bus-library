package inc.droidflick.ottoeventbustutorial.accessors;

/**
 * Created by Atif Arif on 4/2/2018.
 */

public class Accessors {


    private static Accessors instance = null;

    private boolean isRegistered = false;


    public Accessors() {

    }

    public static Accessors getInstance() {
        if (instance == null) {
            instance = new Accessors();
        }

        return instance;
    }


    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}
