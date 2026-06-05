package hooks;

import java.time.Duration;



import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BaseTest{
	@Before
	  public void setupScenario() {
		  browserLaunch();
		    
		  
	  }
	
	@After
	public void tearDownScenario() {
		closeBrowser();
	}

}
