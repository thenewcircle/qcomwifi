package qcom.wifiservice;

import android.os.RemoteException;
import android.util.Log;

import qcom.wificommon.IQWifiService;

public class IQWifiServiceImpl extends IQWifiService.Stub {
    static final String TAG = "QWifi";
    
    QWifiLib qWifiLib;
    
    public IQWifiServiceImpl() {
        qWifiLib = new QWifiLib();
    }
    
    @Override
    public int connect(String ssid) throws RemoteException {
        Log.d(TAG, "connect with ssid: "+ssid);
        return qWifiLib.connect(ssid);
    }

    @Override
    public int enableWifi() throws RemoteException {
        Log.d(TAG, "enableWifi");
        return qWifiLib.enableWifi();
    }

}
