package pro.kbgame.demeter.network;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import pro.kbgame.demeter.common.SmsConverter;

public class SmsService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String sms_body = intent.getExtras().getString("sms_body");
        SmsConverter.getInstance(this).setStatusFromSms(sms_body);
        return START_STICKY;
    }


}
