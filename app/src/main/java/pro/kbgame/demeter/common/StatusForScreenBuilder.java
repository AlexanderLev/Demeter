package pro.kbgame.demeter.common;

import pro.kbgame.demeter.model.Settings;
import pro.kbgame.demeter.model.Status;

public class StatusForScreenBuilder {

    //Set names from settings to status.

    private Settings settings;
    private Status status;
    private Status statusOnScreen;
    enum BarrelsName{ShowerBarrel, WateringBarrel}

    public StatusForScreenBuilder(){}

    public StatusForScreenBuilder(Settings settings, Status status){
        this.settings = settings;
        this.status = status;
    }

    public Status getStatusForScreen(){
        return new Status();
    }

}
