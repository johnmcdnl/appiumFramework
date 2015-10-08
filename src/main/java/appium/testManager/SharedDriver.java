package appium.testManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import appium.config.DriverFactory;
import appium.devices.DeviceType;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SharedDriver extends EventFiringWebDriver {
	
	public SharedDriver() {
		super(getSharedDriver());
	}
	
	private static AppiumDriver<MobileElement> sharedDriver = null;

	public static AppiumDriver<MobileElement> getSharedDriver() {
		if (sharedDriver == null) {
			sharedDriver = new DriverFactory().newDriver(DeviceType.ANDROID);
		}
		return sharedDriver;
	}

	public static void setSharedDriver(AppiumDriver<MobileElement> appiumDriver) {
		SharedDriver.sharedDriver = appiumDriver;
	}



	public static void embedScreenshot(Scenario scenario) {
		captureScreenshot(String.valueOf(System.currentTimeMillis()));
		try {
			byte[] screenshot = Files.readAllBytes(getScreenshot().toPath());
			scenario.embed(screenshot, "image/png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static File getScreenshot() {
		System.out.println("Capturing the snapshot of the page ");
		File file = ((TakesScreenshot) sharedDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\dev\\workspace\\appium-UiSlider\\build\\cucumber-html-report\\test"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	public static void captureScreenshot(String testName) {
	    String imagesLocation = "build/screenshot/";
	    new File(imagesLocation).mkdirs(); // Insure directory is there
	    String filename = imagesLocation + testName + ".jpg";

	    try {
	        Thread.sleep(500);
	        WebDriver augmentedDriver = new Augmenter().augment(getSharedDriver());
	        File scrFile = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File(filename), true);
	    } catch (Exception e) {
	        System.out.println("Error capturing screen shot of " + testName + " test failure.");
	        // remove old pic to prevent wrong assumptions
	        File f = new File(filename);
	        f.delete(); // don't really care if this doesn't succeed, but would like it to.
	    }
	}

}
