package pro.kbgame.demeter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Status {
    private Date date;
    private int temp;
    private int humidity;
    private int soil;
    private List<Barrel> barrelList;
    private List<WaterReceiver> waterReceiverList;

    public Status (){
        date = new Date();
        temp = 0;
        humidity = 0;
        soil = 0;
        waterReceiverList = new ArrayList<WaterReceiver>();
        for(int i = 0; i < 6; i++){
            waterReceiverList.add(new WaterReceiver(i));
        }
        barrelList = new ArrayList<Barrel>();
        barrelList.add(0, new Barrel("Showering barrel", false, false));
        barrelList.add(1,new Barrel("Watering barrel", false, false));
    }

    public Status(List<Barrel> barrelList, List<WaterReceiver> waterReceiverList){
        this.barrelList = barrelList;
        this.waterReceiverList = waterReceiverList;
    }

    public Status(Date date, int temp, int humidity, int soil, List<Barrel> barrelList, List<WaterReceiver> waterReceiverList){
        this.date = date;
        this.temp = temp;
        this.humidity = humidity;
        this.soil = soil;
        this.barrelList = barrelList;
        this.waterReceiverList = waterReceiverList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getSoil() {
        return soil;
    }

    public void setSoil(int soil) {
        this.soil = soil;
    }

    public List<Barrel> getBarrelList() {
        return barrelList;
    }

    public void setBarrelList(List<Barrel> barrelList) {
        this.barrelList = barrelList;
    }

    public List<WaterReceiver> getWaterReceiverList() {
        return waterReceiverList;
    }

    public void setWaterReceiverList(List<WaterReceiver> waterReceiverList) {
        this.waterReceiverList = waterReceiverList;
    }

}
