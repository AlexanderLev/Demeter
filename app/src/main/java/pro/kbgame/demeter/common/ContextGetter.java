package pro.kbgame.demeter.common;

import android.app.Application;
import android.content.Context;

public class ContextGetter extends Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        ContextGetter.context = getApplicationContext();
    }

    public static Context getContext(){
        return ContextGetter.context;
    }
}
