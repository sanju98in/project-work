package financialWeb.workflow;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import financialWeb.pages.FinancialWebHomepage;

public class FinancialWebHomepageWorkflow extends CommonWorkflow{

  static FinancialWebHomepage objFinWebHomePage;
  static FinancialWebLoginpageWorkflow objFinWebLoginPage;

  protected static void verifySignOff() throws InterruptedException, FileNotFoundException {
   waitforPanelLoad(); 
   objFinWebHomePage= new FinancialWebHomepage(driver);     
    IsExist(FinancialWebHomepage.signOut);
    waitForPageLoad();
  }
 
  protected static void clickSignOff() throws InterruptedException, FileNotFoundException {
   waitforPanelLoad(); 
   objFinWebHomePage= new FinancialWebHomepage(driver); 
    waitForPageLoad();
    clickElement(FinancialWebHomepage.signOut);
    waitForPageLoad();
  }

  protected static void getMenuLink(String data) throws InterruptedException, FileNotFoundException {
   waitforPanelLoad(); 
   objFinWebHomePage= new FinancialWebHomepage(driver); 
    waitForPageLoad();
    for(WebElement el:FinancialWebHomepage.listMenu) {
      log.info(el.getText());
      if(el.getText().equalsIgnoreCase(data)) {
        mouseHover(el);
        highlightElement(el);
      }
    }
    clickElement(FinancialWebHomepage.enterRequisition);
    waitForPageLoad();
  }

 
  public static void verifyFinancialsWebMainMenu() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
      objFinWebHomePage = new FinancialWebHomepage(driver);
      waitforSignOut();
      boolean found = true;

    WebElement element = driver.findElement(By.xpath(orprop.getProperty("searchedtext")));
    String title = element.getText();
    if(title.equalsIgnoreCase(testdataprop.getProperty("lblfinancialswebmainmenu")))
    {
      found = false;
      //Thread.sleep(2500);
    } 
    else {
      while(found) {
        WebElement backToFinancialsWebMainMenu = driver.findElement(By.xpath(orprop.getProperty("backToFinancialsWebMainMenu")));
        clickElement(backToFinancialsWebMainMenu);
        element = driver.findElement(By.xpath(orprop.getProperty("searchedtext")));
        if(element.getText().equalsIgnoreCase(testdataprop.getProperty("lblfinancialswebmainmenu")))
        {
          log.info("Pass: Financial Web Menu is displayed");
          //Thread.sleep(1000);
          break;
        }
      }
    }
    //WaitForElementDisapper();
    waitforPanelLoad();
  } 
  
  public static void verifySearchListItem(String data) throws InterruptedException, FileNotFoundException {
    waitforPanelElement(FinancialWebHomepage.searchLists);
    IsExist(FinancialWebHomepage.searchLists);
    List<WebElement> el=driver.findElements(By.xpath(orprop.getProperty("menusearchedtext")));
    for(WebElement e:el){
      if(e.getText().equalsIgnoreCase(data));
      e.click();
      Thread.sleep(1000);
      break;
    }
    if(FinancialWebHomepage.pnlSearch.getText().equals(data))
      log.info("Pass: Search panel is set as " + FinancialWebHomepage.pnlSearch.getText());
  }
  
  public static void searchLists() throws FileNotFoundException, InterruptedException {
    verifySearchItem();
  }
  
  public static void verifySearchItem() throws FileNotFoundException, InterruptedException {
    objFinWebHomePage = new FinancialWebHomepage(driver);
    waitforPanelElement(FinancialWebHomepage.searchLists);
    IsExist(FinancialWebHomepage.searchLists);
  }

  public static void verifySearchHeader(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
  for (WebElement listItem:FinancialWebHomepage.searchList) {
        if(listItem.getText().equalsIgnoreCase(data)) {
          log.info("Search menu is set to "+ data);
          break;
        }
    }
  }
  
  public static void clickWebMainMenu(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    if(!containsText(FinancialWebHomepage.lblFinancialsWebMainMenu, data))
    {
      verifyFinancialsWebMainMenu();
    }
  }
  
  public static void searchItemFromList(String data) throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    for (WebElement listItem:FinancialWebHomepage.searchList) {
      log.info(listItem.getText());
      if(listItem.getText().equalsIgnoreCase(data)) {
          log.info("Pass: Find " + listItem.getText());
          listItem.click();
          break;
      }
    }
  }
  
  public static void clickManualAddress() throws FileNotFoundException, InterruptedException {
    waitforPanelLoad();
    objFinWebHomePage = new FinancialWebHomepage(driver);
    waitforPanelElement(FinancialWebHomepage.btnManualAddress);
    clickElement(FinancialWebHomepage.btnManualAddress);
    waitforPanelLoad();
  }
  
  //end of class
}