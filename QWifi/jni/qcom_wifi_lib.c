#define LOG_TAG "QcomWifi"
#include <stdio.h>
#include <android/log.h>

int enableWifi() {
	LOGD("enableWifi");
	return 1;
}

int connect( char *ssid ) {
	printf("%s", ssid);
	LOGD("connect");
	return 1;
}
