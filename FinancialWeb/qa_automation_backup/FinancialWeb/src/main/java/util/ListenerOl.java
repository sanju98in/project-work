package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ListenerOl extends TestBase implements ITestListener {


	public ListenerOl() throws FileNotFoundException {
	}

	public static Boolean FLAG=false;
	public static String time = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa").format(new Date());

	public void onTestStart(ITestResult result) {
		log("=======================TEST EXECUTION STARTED: "+result.getMethod().getMethodName() + "=======================");
	}

	public void onTestSuccess(ITestResult result) {
		try {
	    if (envprop.getProperty("screenShotOnPass").equalsIgnoreCase("YES"))
		{
		    StoreScreenshot(result,"Success");
		}
		}
		catch (Exception E) {
		  log("Screenshot not Captured");
		}
		log("=======================TEST EXECUTION COMPLETED WITH SUCCESS: " + result.getMethod().getMethodName() + "=======================");
		

	}

	public void onTestFailure(ITestResult result) {
	 try {
	  if (envprop.getProperty("screenShotOnFail").equalsIgnoreCase("YES"))
      {
	    StoreScreenshot(result,"Failure");
      }
	 }
	 catch (Exception E) {
       log("Screenshot not Captured");
     }
	  log.error(result);
	  log("=======================TEST EXECUTION COMPLETED WITH FAILURE: " + result.getMethod().getMethodName() + "=======================");
	}

	@SuppressWarnings("unused")
	public void StoreScreenshot(ITestResult result,String resulttype) {
		Date now = new Date();
		String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
		try {

			//To capture screenshot.
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			File Path;

			File parentDir = new File(configpath + "\\screenshots\\" );
			if(!parentDir.exists()) {
				parentDir.mkdir();
			}
			File childDir = new File(parentDir + "\\" +time +"\\" );
			if(!childDir.exists()) {
				childDir.mkdir();
			}
			if(resulttype=="Success") {
				Path= new File(childDir+"\\success\\");
				log.info("Test Pass and captured success screenshot");
			}
			else {
				Path= new File(childDir+"\\Failure\\");
				log.info("Test fail and captured failure screenshot");
			}

			if(!Path.exists()) {
				Path.mkdir();
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
			String destFile = passfailMethod+"_"+dateFormat.format(new Date()) + ".png";
			dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
			destFile = passfailMethod+"_"+dateFormat.format(new Date()) + ".png";


			try {
				//Store file at destination folder location
				FileUtils.copyFile(scrFile, new File(Path + "/" + destFile));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			log.warn(e);
			log.info("no such window: target window already closed\r\n" + 
					"from unknown error: web view not found. " + " Closing Window");
			driver.quit();
		}
	}

	public void onTestSkipped(ITestResult result) {
		log("=======================TEST CASE SKIPPED: " + result.getMethod().getMethodName() + "=======================");
		//log("Text execution skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		//log("Text execution started");
	}

	public void onFinish(ITestContext context) {
	//	log("Text execution completed");
	}

	@BeforeMethod
	public void beforeMethod(Method result) {
	}

	@AfterMethod
	public void afterMethod(ITestResult result,String status) {
	}

	@AfterClass
	public void endTest() {
		closeBrowser();

	}
}
