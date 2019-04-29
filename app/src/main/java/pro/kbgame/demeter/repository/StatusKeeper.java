package pro.kbgame.demeter.repository;

import android.content.Context;

import pro.kbgame.demeter.common.NamesCombiner;
import pro.kbgame.demeter.model.Settings;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.view.MainActivity;

public class StatusKeeper implements MainActivity.StatusCallBack {

    private static StatusKeeper instance;
    Context context;
    private Status currentStatus;

    public static StatusKeeper getInstance(Context context) {
        if (instance == null) {
            instance = new StatusKeeper(context);
        }
        return instance;
    }

    private StatusKeeper(Context context) {
        this.context = context;
        initStatus();
    }

    @Override
    public Status statusCallBack() {
        return getCurrentStatus();
    }

    public Status getCurrentStatus() {
        if (currentStatus != null) {
            updateCurrentStatus();
        } else {
            currentStatus = new Status();
        }
        return currentStatus;
    }

    public void setCurrentStatus(Status status){
        currentStatus = status;
    }

    private void updateCurrentStatus() {
        Settings settings = PreferencesKeeper.getInstance().loadSettingsFromPrefs(context);
        NamesCombiner namesCombiner = new NamesCombiner(settings, currentStatus);
        currentStatus = namesCombiner.getCombinedNamesStatus();
    }

    private void initStatus() {
        Settings settings = PreferencesKeeper.getInstance().loadSettingsFromPrefs(context);
        NamesCombiner namesCombiner = new NamesCombiner(settings, new Status());
        currentStatus = namesCombiner.getCombinedNamesStatus();

    }

}
