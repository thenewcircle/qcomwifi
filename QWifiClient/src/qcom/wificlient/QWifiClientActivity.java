
package qcom.wificlient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class QWifiClientActivity extends Activity {
    static final String TAG = "QWifi";
    QWifiManager wifi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (wifi == null)
            wifi = new QWifiManager(this);
    }

    @Override
    protected void onDestroy() {
        wifi.close();
        super.onDestroy();
    }

    /** Called when button in clicked. */
    public void onClick(View v) {
        wifi.enableWifi();
        Log.d(TAG, "onClick got: " + wifi.connect("MySSID"));
    }

}
