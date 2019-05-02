package pro.kbgame.demeter.network;

import android.content.Context;

import pro.kbgame.demeter.repository.PreferencesKeeper;

public class SmsWorker {
    Context context;

    public SmsWorker(Context context) {
        this.context = context;
    }

    public void sendSmsToReceiver(String message) {
        String receivingPhoneNumber = "smsto:" + PreferencesKeeper.getInstance().loadSettingsFromPrefs(context).getReceivingPhoneNumber();
        android.telephony.SmsManager.getDefault().sendTextMessage(receivingPhoneNumber, null, message, null, null);
    }

}
