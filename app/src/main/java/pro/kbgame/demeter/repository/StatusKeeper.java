package pro.kbgame.demeter.repository;

import android.content.Context;

import pro.kbgame.demeter.common.MyAppContext;
import pro.kbgame.demeter.common.NamesCombiner;
import pro.kbgame.demeter.model.Settings;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.view.MainActivity;

public class StatusKeeper implements MainActivity.StatusCallBack {

    private static StatusKeeper instance;
    private Status currentStatus;

    public static StatusKeeper getInstance() {
        if (instance == null) {
            instance = new StatusKeeper();
        }
        return instance;
    }

    public StatusKeeper() {
        initStatus();
    }

    @Override
    public Status statusCallBack() {
        return getCurrentStatus();
    }

    public Status getCurrentStatus() {
        if (currentStatus != null) {
            updateCurrentNamesInStatus();
        } else {
            currentStatus = new Status();
        }
        return currentStatus;
    }

    public void setCurrentStatus(Status status){
        currentStatus = status;
    }

    private void updateCurrentNamesInStatus() {
        Settings settings = PreferencesKeeper.getInstance().loadSettingsFromPrefs(MyAppContext.getContext());
        NamesCombiner namesCombiner = new NamesCombiner(settings, currentStatus);
        currentStatus = namesCombiner.getCombinedNamesStatus();
    }

    private void initStatus() {
        Settings settings = PreferencesKeeper.getInstance().loadSettingsFromPrefs(MyAppContext.getContext());
        NamesCombiner namesCombiner = new NamesCombiner(settings, new Status());
        currentStatus = namesCombiner.getCombinedNamesStatus();

    }

}
