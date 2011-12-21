
package qcom.wificlient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import qcom.wificommon.IQWifiService;

public class QWifiClientActivity extends Activity {
    static final String TAG = "QWifiClientActivity";
    IQWifiService service;
    QWifiServiceConnection connection;
    static final Intent INTENT = new Intent("qcom.wificommon.IQWifiService");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        connection = new QWifiServiceConnection();
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(INTENT, connection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        unbindService(connection);
        super.onStop();
    }

    /** Called when button in clicked. */
    public void onClick(View v) {
        try {
            service.connect("MySSID");
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to connect to service", e);
        }
    }

    /** Responsible for handling connection/disconnection to remote service. */
    class QWifiServiceConnection implements ServiceConnection {

        /** Called once we successfully bound to remote service. */
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service = IQWifiService.Stub.asInterface(binder);
            Log.d(TAG, "onServiceConnected");
        }

        /** Remote service got disconnected. */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            service = null;
            Log.d(TAG, "onServiceDisconnected");
        }

    }
}
