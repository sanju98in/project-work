package upmcms.testScripts;

import java.util.List;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class testMe {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Started!");
    TestNG testng = new TestNG();
    List<String> suites = Lists.newArrayList();
    suites.add("testng.xml");//path to xml
    testng.setTestSuites(suites);
    testng.run();
    
  }
}
