package appium.config;

import java.io.File;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumConfiguration {
	private File getAndroidAppLocation() {
		String apkLocation = "applicationPackages/RememberTheDate.apk";
		return new File(AppiumConfiguration.class.getClassLoader().getResource(apkLocation).getFile());
	}

	public static DesiredCapabilities getDesiredCapabilitiesAndroid() {
		AppiumConfiguration appiumConfiguration = new AppiumConfiguration();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4");
		capabilities.setCapability("deviceName", "AppiumEmulator");
		capabilities.setCapability("app", appiumConfiguration.getAndroidAppLocation().getAbsolutePath());
		capabilities.setCapability("appPackage", "com.zendesk.rememberthedate");
		capabilities.setCapability("appActivity", ".ui.MainActivity");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
		return capabilities;
	}
}
