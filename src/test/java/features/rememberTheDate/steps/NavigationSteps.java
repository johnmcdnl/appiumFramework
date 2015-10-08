package features.rememberTheDate.steps;

import java.util.List;

import org.junit.Assert;

import appium.pageObjects.rememberTheDate.nav.NavActions;
import cucumber.api.java.en.Then;

public class NavigationSteps {
	@Then("^I see the navigation bar$")
	public void iSeeTheNavigationBar() throws Throwable {
		NavActions navActions = new NavActions();
		Assert.assertTrue("Navigation Bar was not found!", navActions.isNavDisplayed());
	}

	@Then("^I see each navigation bar option displayed$")
	public void iSeeEachNavigationBarOptionDisplayed() throws Throwable {
		List<String> options = new NavActions().getNavOptionsDisplayed();
		for (String option : options) {
			System.out.println(option);
		}
	}

	@Then("^I see a navigation bar option for \"([^\"]*)\"$")
	public void iSeeANavigationBarOptionFor(String nameOptionName) throws Throwable {
		NavActions navActions = new NavActions();
		List<String> options = navActions.getNavOptionsDisplayed();
		Assert.assertTrue(options.contains(nameOptionName));
		navActions.selectNavOption(nameOptionName);

	}
}
