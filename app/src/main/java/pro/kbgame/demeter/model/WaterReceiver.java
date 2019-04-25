package pro.kbgame.demeter.model;

public class WaterReceiver {
    private int switchNumber;
    private String name;
    private boolean watering;
    private boolean turnOnWatering;
    private int timeInMin;

    public WaterReceiver(int switchNumber, String name, boolean watering, boolean turnOnWatering, int timeInMin) {
        this.switchNumber = switchNumber;
        this.name = name;
        this.watering = watering;
        this.turnOnWatering = turnOnWatering;
        this.timeInMin = timeInMin;
    }

    public int getSwitchNumber() {
        return switchNumber;
    }

    public void setSwitchNumber(int switchNumber) {
        this.switchNumber = switchNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWatering() {
        return watering;
    }

    public void setWatering(boolean watering) {
        this.watering = watering;
    }

    public boolean isTurnOnWatering() {
        return turnOnWatering;
    }

    public void setTurnOnWatering(boolean turnOnWatering) {
        this.turnOnWatering = turnOnWatering;
    }

    public int getTimeInMin() {
        return timeInMin;
    }

    public void setTimeInMin(int timeInMin) {
        this.timeInMin = timeInMin;
    }
}
