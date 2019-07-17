package projectName.step_definitions;


import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.TestBase;

public class Hooks extends TestBase{
    public static WebDriver driver;

    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void launchApplication() throws MalformedURLException {
    	
    	TestBase.init();
    	driver=TestBase.driver;
   }
     
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void TakeScreenshotandTearDown(Scenario scenario) throws InterruptedException {
       
        if(scenario.isFailed()) 
        	StoreScreenshot("Fail");
        else
        	StoreScreenshot("Success");
        driver.quit();
    }
}