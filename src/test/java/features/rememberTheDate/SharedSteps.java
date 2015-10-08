package features.rememberTheDate;

import appium.testManager.TestManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class SharedSteps {

	@Before
	public void before() {
		new TestManager().beforeTest();
	}

	@After
	public void after(Scenario scenario) {
		new TestManager().afterTest(scenario);
	}

	@Given("^I have launched the app$")
	public void iHaveLaunchedTheApp() throws Throwable {
		System.out.println(TestManager.getDriver().getAppStrings());
	}
	
	
}
