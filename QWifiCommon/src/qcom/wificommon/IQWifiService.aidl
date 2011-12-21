package qcom.wificommon;

interface IQWifiService {
	int connect(String ssid);
	int enableWifi();
	QWifiInfo getConnectionInfo();
}