package financialWeb.pages;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class FinancialWebLoginpage extends CommonPage {

	public static final Logger log= Logger.getLogger(FinancialWebLoginpage.class.getName());
	
	public static WebDriver driver;

	//Page Factory - OR:
	
	//parameterize constructor to initalize driver and page factory web element
	public FinancialWebLoginpage(WebDriver driver) throws FileNotFoundException{
	    driver=TestBase.driver;
		PageFactory.initElements(driver, this);
	}

	public FinancialWebLoginpage()  throws FileNotFoundException{
	}
}
