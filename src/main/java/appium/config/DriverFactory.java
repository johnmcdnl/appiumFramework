package appium.config;

import appium.devices.DeviceType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	public AppiumDriver<MobileElement> newDriver(DeviceType deviceType) {
		switch (deviceType) {
		case ANDROID:
			return new AndroidDriver<>(AppiumConfiguration.getDesiredCapabilitiesAndroid());

		default:
			break;
		}
		return null;

	}
}
