package appium.testManager;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestManager {

	public static AppiumDriver<MobileElement> getDriver() {
		return SharedDriver.getSharedDriver();
	}

	public void beforeTest() {
		System.out.println("Doing something before the test");
	}

	public void afterTest(Scenario scenario) {
		SharedDriver.embedScreenshot(scenario);
	}
}
