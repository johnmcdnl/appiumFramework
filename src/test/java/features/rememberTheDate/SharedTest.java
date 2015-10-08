package features.rememberTheDate;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features={"classpath:features/rememberTheDate"},
    dryRun = false,
    strict = true,
    snippets = SnippetType.CAMELCASE,
    plugin = {"pretty", "html:build/cucumber-html-report", "json:build/cucumber-report.json"}
    )
public class SharedTest {

}
