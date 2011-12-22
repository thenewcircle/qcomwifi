package qcom.wificommon;

import qcom.wificommon.QWifiInfo;

interface IQWifiService {
	int connect(String ssid);
	int enableWifi();
	QWifiInfo getConnectionInfo();
}