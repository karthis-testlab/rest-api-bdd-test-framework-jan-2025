package test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/features/Incident.feature"},
		          glue = {"step.defs.som"},
		          dryRun = false,
		          plugin = {"pretty", "html:reports/result.html"},
		          publish = false,
		          tags = ""
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}