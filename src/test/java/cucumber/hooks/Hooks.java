package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	
	@Before
	public void runBeforeEachScenario() {
		System.out.println("Before SCenario");
	}
	
	@After
	public void runAfterEachScenario() {
		System.out.println("After SCenario");
	}
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("Before Step");
	}
	
	@AfterStep
	public void afterStep() {
		System.out.println("After Step");
	}

}