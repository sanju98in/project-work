package upmcms.workflow;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import upmcms.pages.MyPension;

/**
 * @author CIVICA
 */
public class MyPensionWorkflow extends CommonWorkflow{

  protected void validateSecurityMsg(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    waitForPageLoad();
    validateMessage(MyPension.lblIncorrectPassword, data);
  }
  
  
  protected void validateLabel(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    waitForPageLoad();
    validateMessage(MyPension.lblDashboard, data);
  }
  
  protected void myMembershipDetails(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    searchTableColumn(MyPension.tblMembershipDetails,data);
    waitForPageLoad();
  }
  
  protected void searchAndClickMyMembershipDeDetailsLink(String dataset) throws InterruptedException, FileNotFoundException {
    objMyPension = new MyPension(driver);
    searchAndClickLinkText(dataset,MyPension.lstMembershipDetailsLinks);
    waitForPageLoad();
  }
  
  protected void validateUpdateNominationLabel(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    waitForPageLoad();
    validateMessage(MyPension.lblUpdateMyNomination, data);
    waitForPageLoad();
  }
  

  protected void selectNominee(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    Select oSelect = new Select(MyPension.drpdnAddNominee);
    oSelect.selectByVisibleText(data);
    submitChanges();
    Thread.sleep(3000);
  }

  protected void updateNomination(String nmne,String rltnToMembers,String day,String month, String year,String nmType,String bnftPctg,String addNmne) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtNominee, nmne);
   Select oSelect = new Select (MyPension.drpdnRlToMember);
   oSelect.selectByVisibleText(rltnToMembers);
   selectDate(MyPension.calDOB,day,month,year);
   oSelect = new Select(MyPension.drpdnNominationType);
   oSelect.selectByVisibleText(nmType);
   setText(MyPension.txtPctOfBenefits,bnftPctg);
   oSelect = new Select(MyPension.drpdnAddNominee);
   oSelect.selectByVisibleText(addNmne);
  }
  
  protected ArrayList<String> createMultipleNomination(String limit,String rltnToMembers,String day,String month, String year,String nmType,String bnftPctg,String addNmne) throws FileNotFoundException, InterruptedException {
    waitForPageLoad();
    for(int i=1;i<=Integer.parseInt(limit);i++) {
    randomString = getRandomString(testdataprop.getProperty("randomstringlimit"));
    objMyPension = new MyPension(driver);
    
    WebElement nmneeName = driver.findElement(By.xpath("//*[@data-fieldname='NOM"+i+"']/div[2]/input"));
    setText(nmneeName, randomString);
    allNominatedBeneficiaries.add(randomString);
    WebElement rltnToMember = driver.findElement(By.xpath("//*[@data-fieldname='RTM"+i+"']/div[2]/select"));
    Select oSelect = new Select (rltnToMember);
    oSelect.selectByVisibleText(rltnToMembers);
    
    WebElement dob = driver.findElement(By.xpath("//*[@data-fieldname='DOB"+i+"']/div[2]/button/i"));
    selectDate(dob,day,month,year);
    
    WebElement nmntype = driver.findElement(By.xpath("//*[@data-fieldname='NTY"+i+"']/div[2]/select"));
    oSelect = new Select(nmntype);
    oSelect.selectByVisibleText(nmType);
    
    WebElement bnftpctg = driver.findElement(By.xpath("//*[@data-fieldname='POB"+i+"']/div[2]/input"));
    setText(bnftpctg,bnftPctg);
    
    if(i==10) {
      submitChanges();
      waitForPageLoad();
    }else {
      WebElement wantToAddMoreNominerr = driver.findElement(By.xpath("//*[@data-fieldname='ADD"+i+"']/div[2]/select"));
      oSelect = new Select(wantToAddMoreNominerr);
      oSelect.selectByVisibleText(addNmne);
    }
   }
    waitForPageLoad();
    return allNominatedBeneficiaries;
  }
  
 protected void selectDate(WebElement cal,String day,String month,String year) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   boolean found = cal.isDisplayed();
   if(found) {
     cal.click();
     WebElement drpdnMonth = driver.findElement(By.xpath(orprop.getProperty("month")));
       drpdnMonth.click();
       Select oSelect = new Select (drpdnMonth);
       oSelect.selectByVisibleText(month);
       Thread.sleep(500);
       WebElement drpdnYear = driver.findElement(By.xpath(orprop.getProperty("year")));
       drpdnYear.click();
       oSelect = new Select (drpdnYear);
       oSelect.selectByVisibleText(year);
       List<WebElement> days = driver.findElements(By.xpath(orprop.getProperty("day")));
       for(WebElement myday:days) {
         if(myday.getText().trim().equalsIgnoreCase(day.trim())) {
           highlightElement(myday);
           myday.click();
           found=false;
           break;
         }
       }
     }
   }
 
 protected void SetNewNominee(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   Select oSelect = new Select(MyPension.drpdnAddNominee);
   oSelect.selectByVisibleText(data);
   waitForPageLoad();
 }
 
 protected void setPercentageOfBenefits(String data) throws FileNotFoundException {
   objMyPension = new MyPension(driver);
   MyPension.txtPctOfBenefits.clear();
   MyPension.txtPctOfBenefits.sendKeys(data);
   MyPension.txtPctOfBenefits.sendKeys(Keys.TAB);
 }
 
 protected void setPercentageOfBenefitsForAnotherNominee(String data) throws FileNotFoundException {
   objMyPension = new MyPension(driver);
   MyPension.txtPctOfBenefits.clear();
   MyPension.txtPctOfBenefits.sendKeys(data);
   MyPension.txtPctOfBenefitsNmneTwo.sendKeys(Keys.TAB);
 }
 
 protected void isNewBankAcBasedInUK(String data) throws Exception {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   for(WebElement radioOption:MyPension.rdbNewBankAcInUK) {
     if(radioOption.getAttribute("value").trim().equalsIgnoreCase(data.trim())){
       clickElement(radioOption);
       break;
     }
   }
 }
 
 protected void selectEffectiveDateOfChange() throws InterruptedException, FileNotFoundException {
   objMyPension = new MyPension(driver);
   clickElement(MyPension.calEffectiveDateOfChange);
 }
 
 protected void searchAndClickMyMembershipDetailsLink(String dataset) throws FileNotFoundException, InterruptedException  {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   searchAndClickLinkText(dataset,MyPension.lstMyMembershipLinks);
   waitForPageLoad();
 }

 protected void setBankSortCode(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtBankSortCode, data);
 }
 
 protected void setBankBranch(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtBankBranch, data);
 }
 
 protected void setBankName(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtBankName, data);
 }
 
 protected void validateSearchResults(String data) throws InterruptedException {
   waitForPageLoad();
   WebElement element = driver.findElement(By.xpath(data));
   IsExist(element);
 }
 
 protected void clearSortCode() throws InterruptedException, FileNotFoundException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   clearText(MyPension.txtBankSortCode);
 }
 
 protected void selectBankDetailRadioOption(String data) {
   WebElement radioOption = driver.findElement(By.xpath(data));
   clickElement(radioOption);
 }
 
 protected void setAccountName(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtAccountName, data);
 }
 
 protected void setBankAccountName(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtBankAccountName, data);
 }
 
 protected void setAccountNumber(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtAccountNo, data);
 }

 protected void setBankAccountNumber(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtBankAccountNo, data);
 }
 
 protected void setPaymentRef(String data) throws FileNotFoundException, InterruptedException {
   waitForPageLoad();
   objMyPension = new MyPension(driver);
   setText(MyPension.txtPaymentRef, data);
 }

 protected void selectRadioOption(String list,String data) throws InterruptedException {
   waitForPageLoad();
   List<WebElement> listItems = driver.findElements(By.xpath(list));
   int size = listItems.size();
   for(int i = 0;i<size;i++) {
     if(listItems.get(i).getAttribute("data-radionname").trim().equalsIgnoreCase(data.trim())) {
       clickElement(listItems.get(i));
     }
   }
   waitForPageLoad();
 }
  protected void selectBuildingSocietyAccount(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    for(WebElement radioOption:MyPension.rdbRadioOptions)
      if(radioOption.getAttribute("data-radionname").trim().equalsIgnoreCase(data.trim())) {
        clickElement(radioOption);
        waitForPageLoad();
        break;
        
      }else {
        log.info(KEYWORD_FAIL + "Could not find the radio option");
      }
  }
  
  protected void downloadPDF(String data) throws FileNotFoundException, InterruptedException {
    objMyPension = new MyPension(driver);
    boolean found =IsExist(MyPension.lnkViewPayslip);
    if(found) {
      clickElement(MyPension.lnkViewPayslip);;
      waitForPageLoad();
    }
  }
 
  protected void validateNominatedBeneficiaries(String table, ArrayList<String> allNominatedBeneficiaries) throws InterruptedException{
    waitForPageLoad();
    int size = allNominatedBeneficiaries.size();
    for(int i =0;i<size;i++) {
      waitForPageLoad();
      searchTableColumn(table, allNominatedBeneficiaries.get(i));
    }
  }
}//end of class
