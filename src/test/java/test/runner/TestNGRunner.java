package test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/features/Incident.feature"},
		          glue = {"step.defs"},
		          dryRun = false
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}