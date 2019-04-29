package pro.kbgame.demeter.repository;

import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.view.MainActivity;

public class StatusKeeper implements MainActivity.StatusCallBack {

    private static StatusKeeper instance;
    MainActivity.StatusCallBack statusCallBack;
    private Status currentStatus;

    public static StatusKeeper getInstance(MainActivity.StatusCallBack statusCallBack) {
        if(instance == null){
            instance = new StatusKeeper(statusCallBack);
        }
        return instance;
    }

    private StatusKeeper(MainActivity.StatusCallBack statusCallBack){
        this.statusCallBack = statusCallBack;
    }

    @Override
    public Status statusCallBack() {
        return getCurrentStatus();
    }

    public Status getCurrentStatus(){
        if (currentStatus != null){
            return currentStatus;
        }
        else {currentStatus = new MockStatus().getStatus();}
        return currentStatus;
    }

    public void setCurrentStatus(){
        // receive from sms
    }

}
