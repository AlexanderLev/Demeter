package pro.kbgame.demeter.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import pro.kbgame.demeter.common.ContextGetter;
import pro.kbgame.demeter.model.Settings;

public class PreferencesKeeper{

    private final String FIELD_NAME_ONE = "fieldNameOne";
    private final String FIELD_NAME_TWO = "fieldNameTwo";
    private final String FIELD_NAME_THREE = "fieldNameThree";
    private final String FIELD_NAME_FOUR = "fieldNameFour";
    private final String FIELD_NAME_FIVE = "fieldNameFive";
    private final String FIELD_NAME_SIX = "fieldNameSix";
    private final String RECEIVING_PHONE_NUMBER = "receivingPhoneNumber";
    private final String REMIND_ABOUT_WATERING = "remindAboutWatering";

    private static PreferencesKeeper instance;
    private SharedPreferences sharedPreferences;

    private PreferencesKeeper(){}

    public static PreferencesKeeper getInstance() {
        if (instance == null){
            instance = new PreferencesKeeper();
        }
        return instance;
    }

    public void saveSettingsToPrefs(Settings settings){
        Context context = ContextGetter.getContext();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FIELD_NAME_ONE, settings.getFieldNameOne());
        editor.putString(FIELD_NAME_TWO, settings.getFieldNameTwo());
        editor.putString(FIELD_NAME_THREE, settings.getFieldNameThree());
        editor.putString(FIELD_NAME_FOUR, settings.getFieldNameFour());
        editor.putString(FIELD_NAME_FIVE, settings.getFieldNameFive());
        editor.putString(FIELD_NAME_SIX, settings.getFieldNameSix());
        editor.putString(RECEIVING_PHONE_NUMBER, settings.getReceivingPhoneNumber());
        editor.putBoolean(REMIND_ABOUT_WATERING, settings.isRemindAboutWatering());

        editor.apply();
    }


    public Settings loadSettingsFromPrefs(){
        Context context = ContextGetter.getContext();
        Settings settings = new Settings();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        settings.setFieldNameOne(sharedPreferences.getString(FIELD_NAME_ONE, ""));
        settings.setFieldNameTwo(sharedPreferences.getString(FIELD_NAME_TWO,""));
        settings.setFieldNameThree(sharedPreferences.getString(FIELD_NAME_THREE, ""));
        settings.setFieldNameFour(sharedPreferences.getString(FIELD_NAME_FOUR,""));
        settings.setFieldNameFive(sharedPreferences.getString(FIELD_NAME_FIVE,""));
        settings.setFieldNameSix(sharedPreferences.getString(FIELD_NAME_SIX,""));
        settings.setReceivingPhoneNumber(sharedPreferences.getString(RECEIVING_PHONE_NUMBER,""));
        settings.setRemindAboutWatering(sharedPreferences.getBoolean(REMIND_ABOUT_WATERING, false));
        return settings;
    }


    public boolean isDataPresent() {
        Settings settings = loadSettingsFromPrefs();
        return (!settings.getReceivingPhoneNumber().isEmpty());
    }
}
