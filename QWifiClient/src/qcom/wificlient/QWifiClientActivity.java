
package qcom.wificlient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class QWifiClientActivity extends Activity {
    static final String TAG = "QWifi";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /** Called when button in clicked. */
    public void onClick(View v) {
        QWifiManager wifi = ((QWifiApplication) getApplication()).wifi;
        
        wifi.enableWifi();
        Log.d(TAG, "onClick got: " + wifi.connect("MySSID"));
    }

}
