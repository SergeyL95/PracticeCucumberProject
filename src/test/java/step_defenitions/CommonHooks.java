package step_defenitions;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;

public class CommonHooks {
	@Before
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
	}
	
	@After
	public void teardown() {
		Driver.quitDriver();
	}
}
