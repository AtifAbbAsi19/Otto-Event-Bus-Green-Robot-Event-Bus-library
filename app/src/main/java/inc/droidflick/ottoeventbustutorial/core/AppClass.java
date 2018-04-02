package inc.droidflick.ottoeventbustutorial.core;

import android.app.Application;


import com.squareup.otto.ThreadEnforcer;

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

    }
}