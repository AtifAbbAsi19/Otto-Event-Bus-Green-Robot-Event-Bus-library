package inc.droidflick.ottoeventbustutorial.event;

import android.content.Context;


import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.io.ObjectStreamException;

import inc.droidflick.ottoeventbustutorial.model.Events;


/**
 * Created by Atif Arif on 4/2/2018.
 */

public class EventBusOtto {


    private static EventBusOtto instance = null;

    private static Bus bus = null;

    private static boolean isRegistered = false;


    public static EventBusOtto getInstance(ThreadEnforcer threadEnforcer) {
        if (instance == null) {
            instance = new EventBusOtto(threadEnforcer);
        }
        return instance;
    }

    /**
     * ThreadEnforcer.MAIN This enforces Otto to send events always from the main thread .!
     * ThreadEnforcer.ANY  and if you dnt want to use main thread, for anyother thread use ANY.!
     **/


    EventBusOtto(ThreadEnforcer threadEnforcer) {
        if (bus == null && threadEnforcer != null) {
            bus = new Bus(threadEnforcer);
        }
    }


    public static void triggerEventWithValue(Events event) {

        if (event != null) {
            bus.post(event);
        }

    }


    /*
    *
    * @param Register Event
     * @param context
     *
    * */

    public static void registerBus(Context context) {
        if (bus != null && !isRegistered) {
            bus.register(context);
            isRegistered = true;
        }
    }



   /*
    *
    * @param unRegister Event
    * @param context
    *
    * */

    public static void unRegisterBus(Context context) {

        if (context != null && bus != null) {
            bus.unregister(context);
            isRegistered = false;
        }

    }


}
