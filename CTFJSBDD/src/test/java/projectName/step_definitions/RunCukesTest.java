package projectName.step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "src/test/resources/features",
		plugin = {"pretty", "html:test-output/CIVICA-Cucumber-html-report","json:cucumber.json"},
		glue= {"projectName.step_definitions"},
		tags = {}
		)
public class RunCukesTest{

}