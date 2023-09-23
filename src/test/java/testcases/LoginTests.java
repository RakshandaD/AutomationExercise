package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginObjects;
import resuableFunctions.ResuableClass;

public class LoginTests extends ResuableClass {

	public static String filePath="C:\\Users\\raksh\\OneDrive\\Desktop\\AutomationExerciseData.xlsx";
	public static String sheetName="SignUpInfo";	
	LoginObjects lo=new LoginObjects(ResuableClass.driver);
	
	 @BeforeTest
	   public void startUp() throws Exception {
		   launchApp();
	   }
	 
	 @Test(priority = 1)
	 public void loginWithInCorrectCred() {
		 elementAvailable(lo.homepage, true);
		 lo.SignUpOrLoginbtn.click();
		 elementAvailable(lo.LoginToAccTxt, true);
		 lo.loginEmail.sendKeys(readDataFromExcel(4, 2, filePath, sheetName));
		 lo.loginpass.sendKeys(readDataFromExcel(4, 4, filePath, sheetName));
		 lo.Loginbtn.click();
		 elementAvailable(lo.IncorrCredTxt, true);
			 
	 }
	 
	 @Test(priority = 2)
	 public void logoutUser() {
		 elementAvailable(lo.homepage, true);
		 lo.SignUpOrLoginbtn.click();
		 elementAvailable(lo.LoginToAccTxt, true);
		 lo.loginEmail.sendKeys(readDataFromExcel(2, 2, filePath, sheetName));
		 lo.loginpass.sendKeys(readDataFromExcel(2, 4, filePath, sheetName));
		 lo.Loginbtn.click();
		 elementAvailable(lo.loggeInAs, true);
		 lo.logout.click();
		 elementAvailable(lo.LoginToAccTxt, true);
			 
	 }
	 
	 @Test(priority = 3)
	 public void loginWithCorrectCred() {
		 elementAvailable(lo.homepage, true);
		 lo.SignUpOrLoginbtn.click();
		 elementAvailable(lo.LoginToAccTxt, true);
		 lo.loginEmail.sendKeys(readDataFromExcel(3, 2, filePath, sheetName));
		 lo.loginpass.sendKeys(readDataFromExcel(3, 4, filePath, sheetName));
		 lo.Loginbtn.click();
		 elementAvailable(lo.loggeInAs, true);
		 lo.delAcc.click();
		 elementAvailable(lo.acctDelTxt, true);		 
	 }
	  
	  @AfterSuite
	   public void close() {
		  closeApp();
	   }
}
