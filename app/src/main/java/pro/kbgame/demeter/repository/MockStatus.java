package pro.kbgame.demeter.repository;

import pro.kbgame.demeter.model.Status;

public class MockStatus {
    private Status status;


    public void makeMockStatus(){
        status = new Status(24, 740, 35);
    }

    public Status getStatus(){
        if (status == null){
            makeMockStatus();
        }

        return status;
    }

}
