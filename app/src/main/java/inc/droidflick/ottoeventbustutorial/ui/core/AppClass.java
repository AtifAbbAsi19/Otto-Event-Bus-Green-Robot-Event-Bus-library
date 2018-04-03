package inc.droidflick.ottoeventbustutorial.ui.core;

import android.app.Application;

import com.squareup.otto.ThreadEnforcer;

import inc.droidflick.ottoeventbustutorial.accessors.Accessors;
import inc.droidflick.ottoeventbustutorial.event.EventBusOtto;

/**
 * Created by Atif Arif on 4/2/2018.
 */

public class AppClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         *
         * Init Otto
         *
         **/

        EventBusOtto.getInstance(ThreadEnforcer.MAIN);

        /**
         *
         * Getter Setters For Public static Variables
         *
         **/

        Accessors instance = new Accessors();


    }
}
