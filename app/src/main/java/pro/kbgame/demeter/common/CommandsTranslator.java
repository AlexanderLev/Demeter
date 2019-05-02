package pro.kbgame.demeter.common;

import android.content.Context;

import java.util.Date;
import java.util.List;

import pro.kbgame.demeter.model.Barrel;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.model.WaterReceiver;
import pro.kbgame.demeter.network.SmsWorker;
import pro.kbgame.demeter.repository.StatusKeeper;

public class CommandsTranslator {
    private static CommandsTranslator instance;
    private Status status;
    private Context context;

    public static CommandsTranslator getInstance(Context context) {
        if (instance == null) {
            instance = new CommandsTranslator(context);
        }
        return instance;
    }

    private CommandsTranslator(Context context) {
        this.context = context;
    }


    public void turnWatering() {
        if (!anyWateringOn()) {
            SmsWorker smsWorker = new SmsWorker(context);
            smsWorker.sendSmsToReceiver("Off watering all");
        }
        else {
            String command = "Watering on:";
            String objects = parseObjectsToWatering();
            String smsText = command.concat(objects);
            SmsWorker smsWorker = new SmsWorker(context);
            smsWorker.sendSmsToReceiver(smsText);
        }
    }

    public void getCurrentStatus() {
        SmsWorker smsWorker = new SmsWorker(context);
        smsWorker.sendSmsToReceiver("Status");
    }


    public void setStatusFromSms(String smsText) {
        status = StatusKeeper.getInstance(context).getCurrentStatus();
        status.setDate(new Date());
        String statusInStrings[] = smsText.split(";");
        for (String string : statusInStrings
        ) {
            if (string.startsWith("T=")) {
                status.setTemp(parseThirdIntValue(string));
            }
            if (string.startsWith("H=")) {
                status.setHumidity(parseThirdIntValue(string));
            }
            if (string.startsWith("S=")) {
                status.setSoil(parseThirdIntValue(string));
            }
            if (string.startsWith("Showering barrel")) {
                status.getBarrelList().get(0).setFull(isBarrelFull(string));
                status.getBarrelList().get(0).setFilling(isBarrelFilling(string));
            }
            if (string.startsWith("Watering barrel")) {
                status.getBarrelList().get(1).setFull(isBarrelFull(string));
                status.getBarrelList().get(1).setFilling(isBarrelFilling(string));
            }
            if (string.startsWith("Watering off")) {
                for (WaterReceiver waterReceiver : status.getWaterReceiverList()
                ) {
                    waterReceiver.setWatering(false);
                    waterReceiver.setTimeInMin(0);
                }
                for (Barrel barrel : status.getBarrelList()
                ) {
                    barrel.setFilling(false);
                }
            }
            if (string.startsWith("Watering on:")) {
                String[] splittedStrings = string.split(":");
                int[] receiversNumbers = getIntValuesFromSubstring(splittedStrings[1]);
                wateringTurnedOnReceivers(receiversNumbers);
            }

        }
    }


    private int[] getIntValuesFromSubstring(String receiversNumbers) {
        String[] receiversNumbersArray = receiversNumbers.split(",");
        int[] numbers = new int[receiversNumbersArray.length];
        for (int i = 0; i < receiversNumbersArray.length; i++) {
            numbers[i] = Integer.parseInt(receiversNumbersArray[i]);
        }
        return numbers;
    }

    private int parseThirdIntValue(String stringToParse) {
        return Integer.parseInt(stringToParse.substring(2));
    }

    private boolean isBarrelFull(String checkingString) {
        if (checkingString.contains("not full")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isBarrelFilling(String checkingString) {
        if (checkingString.contains("filling")) {
            return false;
        } else {
            return true;
        }
    }

    private void wateringTurnedOnReceivers(int[] receiversNumbers) {
        for (int number : receiversNumbers
        ) {
            for (int i = 0; i < status.getWaterReceiverList().size(); i++) {
                if (status.getWaterReceiverList().get(i).getSwitchNumber() == number) {
                    status.getWaterReceiverList().get(i).setWatering(true);
                }
            }

        }
    }

    private boolean anyWateringOn() {
        boolean watering = false;
        List<Barrel> barrels = StatusKeeper.getInstance(context).statusCallBack().getBarrelList();
        List<WaterReceiver> receivers = StatusKeeper.getInstance(context).statusCallBack().getWaterReceiverList();
        for (WaterReceiver receiver : receivers) {
            if (receiver.isWatering()) {
                watering = true;
            }
        }
        for (Barrel barrel : barrels) {
            if (barrel.isFilling()) {
                watering = true;
            }
        }
        return watering;
    }

    private String parseObjectsToWatering (){
        StringBuilder stringBuilder = new StringBuilder();
        Status statusToParse = StatusKeeper.getInstance(context).getCurrentStatus();
        List<Barrel> barrels = statusToParse.getBarrelList();
        if(barrels.get(0).isFilling()){
            String showerBarFillingOn = "shower barrel;";
            stringBuilder.append(showerBarFillingOn);
        }
        if(barrels.get(1).isFilling()){
            String wateringBarrelFillingOn = "watering barrel;";
            stringBuilder.append(wateringBarrelFillingOn);
        }

        List<WaterReceiver> waterReceiverList = statusToParse.getWaterReceiverList();
        for (WaterReceiver receiver: waterReceiverList
             ) {
            if(receiver.isWatering()){
                String number = String.valueOf(receiver.getSwitchNumber());
                String localSeparator = " - ";
                String time = String.valueOf(receiver.getTimeInMin());
                String globalSeparator = ";";
                stringBuilder.append(number).append(localSeparator).append(time).append(globalSeparator);
            }
        }

        return stringBuilder.toString();
    }
}
