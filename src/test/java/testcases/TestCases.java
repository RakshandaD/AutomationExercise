package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignUpObjects;
import pages.TestCasesObjects;
import resuableFunctions.ResuableClass;

public class TestCases extends ResuableClass {
	
   TestCasesObjects to= new TestCasesObjects(ResuableClass.driver);
   SignUpObjects so= new SignUpObjects(ResuableClass.driver);
   
   @BeforeTest
   public void startUp() throws Exception {
	   launchApp();
   }
   
   @Test
	 public void TestCasestest() throws Exception {
	   elementAvailable(so.homepage, true);
	   to.TestCases.click();
	   elementAvailable(to.validateTCTxt, true);
	   System.out.println(ResuableClass.driver.getCurrentUrl()); 
     }
	
   @AfterSuite
   public void close() {
	  closeApp();
   }
}
