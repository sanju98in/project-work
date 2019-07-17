package projectName.step_definitions;

import org.openqa.selenium.WebDriver;

public class runApp {
	
	public static WebDriver driver;
	
	public runApp() {
		runApp.driver=Hooks.driver;
	}
}
