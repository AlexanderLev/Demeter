package pro.kbgame.demeter.repository;

import android.content.Context;

import pro.kbgame.demeter.common.NamesCombiner;
import pro.kbgame.demeter.model.Settings;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.view.MainActivity;

public class StatusKeeper implements MainActivity.StatusCallBack {

    private static StatusKeeper instance;
    MainActivity.StatusCallBack statusCallBack;
    Context context;
    private Status status;

    public static StatusKeeper getInstance(Context context, MainActivity.StatusCallBack statusCallBack) {
        if(instance == null){
            instance = new StatusKeeper(context, statusCallBack);
        }
        return instance;
    }

    private StatusKeeper(Context context, MainActivity.StatusCallBack statusCallBack){
        this.context = context;
        this.statusCallBack = statusCallBack;
        initStatus();
    }

    @Override
    public Status statusCallBack() {
        return getCurrentStatus();
    }

    public Status getCurrentStatus(){
        if (status != null){
            return status;
        }
        else {status = new MockStatus().getStatus();}
        return status;
    }

    private void initStatus(){
        Settings settings = PreferencesKeeper.getInstance().loadSettingsFromPrefs(context);
        NamesCombiner namesCombiner = new NamesCombiner(settings, new Status());
        status = namesCombiner.getCombinedNamesStatus();

    }


}
