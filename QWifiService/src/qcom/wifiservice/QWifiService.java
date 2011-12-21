package qcom.wifiservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class QWifiService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new IQWifiServiceImpl();
    }

}
