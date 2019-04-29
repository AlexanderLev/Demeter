package pro.kbgame.demeter.repository;

import pro.kbgame.demeter.model.Status;

public class MockStatus{
    private Status status;

    public MockStatus(){
    }

    private void makeMockStatus(){
        status = new Status();

    }

    public Status getStatus(){
        if (status == null){
            makeMockStatus();
        }

        return status;
    }

}
