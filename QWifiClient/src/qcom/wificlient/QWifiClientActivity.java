
package qcom.wificlient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import qcom.wificommon.QWifiInfo;

public class QWifiClientActivity extends Activity {
    static final String TAG = "QWifi";
    TextView out;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        out = (TextView) findViewById(R.id.out);
    }

    /** Called when button in clicked. */
    public void onClick(View v) {
        out.setText("Output:\n");

        QWifiManager wifi = ((QWifiApplication) getApplication()).wifi;

        wifi.enableWifi();
        out.append("Wifi enabled.\n");

        Log.d(TAG, "onClick got: " + wifi.connect("MySSID"));
        out.append("Wifi connected.\n");

        QWifiInfo info = wifi.getConnectionInfo();
        out.append(String.format("Connection:\nSSID:\t%s\nIP Address:\t%d\nSpeed:\t%d",
                info.getSsid(), info.getIpAddress(), info.getLinkSpeed()));
    }
}
