package appium.pageObjects.rememberTheDate.nav;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.MobileElement;

public class NavActions extends NavElements {
	public NavActions() {
		super();
	}

	public boolean isNavDisplayed() {
		return navBar.isDisplayed();
	}

	public List<String> getNavOptionsDisplayed() {
		List<String> optionsFound = new ArrayList<String>();
		for (MobileElement mobileElement : navBarOptions) {
			optionsFound.add(mobileElement.getText());
		}
		return optionsFound;
	}

	public void isNavOptionDisplayed(String navOptionName) {

	}

	public void selectNavOption(String navOptionName) {
		for (MobileElement mobileElement : navBarOptions) {
			if(mobileElement.getText().equalsIgnoreCase(navOptionName)){
				mobileElement.click();
			}
		}
	}
}
