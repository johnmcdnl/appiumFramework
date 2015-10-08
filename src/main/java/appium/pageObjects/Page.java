package appium.pageObjects;

import org.openqa.selenium.support.PageFactory;

import appium.testManager.TestManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page {
	public Page() {
		PageFactory.initElements(new AppiumFieldDecorator(TestManager.getDriver()), this);
	}

}
