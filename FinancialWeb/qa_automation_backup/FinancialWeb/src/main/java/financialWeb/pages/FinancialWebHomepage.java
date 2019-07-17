package financialWeb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

import java.io.FileNotFoundException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FinancialWebHomepage extends CommonPage{

	public final Logger log= Logger.getLogger(FinancialWebHomepage.class.getName());
	public WebDriver driver;

	//Page Factory - OR:

	@FindBy(xpath="//*[@id='navigation']/li[1]/h3")
    @CacheLookup public WebElement lblFinancialWebMenu;
	
	@FindBy(xpath="//*[@type='button' and @value='Complete']")
    public static WebElement  btnComplete;
	
	@FindBy(xpath="//*[@id='divMenu']/a")
	public static List <WebElement> listMenu;
     
	@FindBy(xpath="//a[@id='e0_12o']")
    public static WebElement enterRequisition;
	
	@FindBy(xpath="//*[@type='text' and @value='Menu Search']")
	public static WebElement txtMenuSearchBox;
	
	@FindBy(xpath="//*[@type='button' and @value='Manual Address']")
    public static WebElement btnManualAddress;
	
	@FindBy(xpath="//*[@id='node-FINCRED']")
	@CacheLookup public WebElement lblMenuSearchedTextTitle;
	
	@FindBy(xpath="//*[@type='button' and @value='Go']")
    public static WebElement btnGo;
	
	@FindBy (xpath ="//img[@src='icons/parent.gif']")
	public static WebElement backToFinancialsWebMainMenu;
	
    @FindBy (xpath ="//*[@class='heading-min-max' and @id='panel-min-max-1']/img")
    public static WebElement imgPanelHeader;
	
	@FindBy (xpath ="//*[@id='navigation']/li[1]/h3")
	public static WebElement lblFinancialsWebMainMenu;
	
	@FindBy (xpath ="//*[@id='navigation2']/li")
	public static WebElement searchLists;
	
	 @FindBy(xpath="//a[@id='node-FIN']")
	 public static WebElement pnlSearch;
	 
	 @FindBy(xpath="//*[@id='scrollingMenuContainer']/ul/li")
	 public static List<WebElement> searchList;
	 
	 @FindBy(xpath="//li[@class='nav-return']//a[@id='node-FINGL']")
	 public WebElement pnlGLPayrollBudgeting;
	 
	 @FindBy(xpath="//*[@id='ctl00_Main_fin_control_holder']")
     public static WebElement pnlModuleLoader;
     
     @FindBy(xpath="//*[@alt='Loading...']")
     public List<WebElement> pnlLoading;
	
	/*
	 * Global elements
	 */
	
	 @FindBy(xpath="//*[text()= 'Sign Out']")
	 public static WebElement signOut;
	 
	 @FindBy(xpath="//*[@value='Upload New Attachment' and @type='button']")
     public static WebElement btnUploadNewAttachment;
	 
	 @FindBy(xpath="//a[@id='node-AUTHWEB']")
	  @CacheLookup public WebElement pnlFinancialsWeb;
	
	  
     @FindBy(xpath="//*[@value='Insert Address' and @type='button']")
     public static WebElement btnInsertAddress;
     
     @FindBy(xpath="//*[@value='Insert Contact' and @type='button']")
     public static WebElement btnInsertContact;
     
	public FinancialWebHomepage(WebDriver driver)throws FileNotFoundException{
	  driver=TestBase.driver;
		PageFactory.initElements(driver, this);
	}

	public FinancialWebHomepage() throws FileNotFoundException{
		
	}

}
