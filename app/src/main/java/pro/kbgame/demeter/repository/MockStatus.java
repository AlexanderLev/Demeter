package pro.kbgame.demeter.repository;

import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.view.MainActivity;

public class MockStatus implements MainActivity.StatusCallBack {
    private Status status;
    private MainActivity.StatusCallBack statusCallBack;

    public MockStatus(MainActivity.StatusCallBack statusCallBack){
        this.statusCallBack = statusCallBack;
    }

    private void makeMockStatus(){
        status = new Status(24, 740, 35);
    }

    private Status getStatus(){
        if (status == null){
            makeMockStatus();
        }

        return status;
    }

    @Override
    public Status statusCallBack() {
        return getStatus();
    }

}
