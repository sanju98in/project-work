package upmcms.workflow;

import java.io.FileNotFoundException;

/**
 * @author CIVICA
 */
public class HomePageWorkflow extends CommonWorkflow{

  public String homePageTitle() throws InterruptedException{
    log.info("homePageTitle Started");
    log.info("homePageTitle Finished");
    return driver.getTitle();
  }

  public String loginPageTitle() throws InterruptedException, FileNotFoundException{
    log.info("loginPageTitle Started");
    //read the expected title of landing page 
    String actual =driver.getTitle();
    log.info("loginPageTitle Finished");
    return actual;	
  }


}
