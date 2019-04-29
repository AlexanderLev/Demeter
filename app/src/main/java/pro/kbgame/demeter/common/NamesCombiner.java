package pro.kbgame.demeter.common;

import java.util.ArrayList;

import pro.kbgame.demeter.model.Settings;
import pro.kbgame.demeter.model.Status;

public class NamesCombiner {
    private Settings settings;
    private Status status;

    public NamesCombiner (Settings settings, Status status){
        this.settings = settings;
        this.status = status;
    }

    public Status getCombinedNamesStatus(){
        ArrayList<String> currentNamesList = getCurrentNamesList();
        for(int i = 0; i < status.getWaterReceiverList().size(); i++){
            String name = currentNamesList.get(i);
            status.getWaterReceiverList().get(i).setName(name);
        }

        status.getBarrelList().get(0).setName("Shower barrel");
        status.getBarrelList().get(1).setName("Watering barrel");

        return status;
    }

    private ArrayList<String> getCurrentNamesList(){
        ArrayList<String> namesFromSettings = new ArrayList<String>();
        namesFromSettings.add(settings.getFieldNameOne());
        namesFromSettings.add(settings.getFieldNameTwo());
        namesFromSettings.add(settings.getFieldNameThree());
        namesFromSettings.add(settings.getFieldNameFour());
        namesFromSettings.add(settings.getFieldNameFive());
        namesFromSettings.add(settings.getFieldNameSix());
        return namesFromSettings;
    }


}
