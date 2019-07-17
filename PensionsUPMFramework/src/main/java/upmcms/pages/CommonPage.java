package upmcms.pages;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebElement;

import util.TestBase;

/**Some common methods which can be used for any page actions.
 */

public class CommonPage extends TestBase {

  static HomePage objHomePage;

   public static void mouseHoverMenuAndClickSubMenuLink(WebElement  mainMenu,WebElement subMenu) throws InterruptedException, FileNotFoundException {
    objHomePage= new HomePage(driver);
    mouseHover(mainMenu);
    waitForPageLoad();
    mouseHoverAndClickElement(subMenu);
    waitForPageLoad();
  }

}//end of class