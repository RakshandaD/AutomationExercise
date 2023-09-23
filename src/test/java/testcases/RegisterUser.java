package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignUpObjects;
import resuableFunctions.ResuableClass;

public class RegisterUser extends ResuableClass {

   public static String filePath="C:\\Users\\raksh\\OneDrive\\Desktop\\AutomationExerciseData.xlsx";
   public static String sheetName="SignUpInfo";	
	
   SignUpObjects so= new SignUpObjects(ResuableClass.driver);
   
   @BeforeTest
   public void startUp() throws Exception {
	   launchApp();
   }
   
   @Test(priority = 1)
   public void RegistNewUser() {
		elementAvailable(so.homepage, true);
		so.SignUpOrLoginbtn.click();
		elementAvailable(so.newUserText, true);
		so.signUpName.sendKeys(readDataFromExcel(1, 1, filePath, sheetName));
		so.signUpEmail.sendKeys(readDataFromExcel(1, 2, filePath, sheetName));
		so.signUpBtn.click();
		elementAvailable(so.accntInfoTxt, true);
		so.gender2.click();
		so.accName.sendKeys(readDataFromExcel(1, 3, filePath, sheetName));
		so.accPwd.sendKeys(readDataFromExcel(1, 4, filePath, sheetName));
		Select d= new Select(so.dobDay);
		d.selectByVisibleText(readDataFromExcel(1, 5, filePath, sheetName));
		Select mon= new Select(so.dobMon);
		mon.selectByVisibleText(readDataFromExcel(1, 6, filePath, sheetName));
		Select yr= new Select(so.dobYr);
		yr.selectByVisibleText(readDataFromExcel(1, 7, filePath, sheetName));
		so.news.click();
		so.offer.click();
		so.fName.sendKeys(readDataFromExcel(1, 8, filePath, sheetName));
		so.lName.sendKeys(readDataFromExcel(1, 9, filePath, sheetName));
		so.company.sendKeys(readDataFromExcel(1, 10, filePath, sheetName));
		so.addr1.sendKeys(readDataFromExcel(1, 11, filePath, sheetName));
		so.add2.sendKeys(readDataFromExcel(1, 12, filePath, sheetName));
		Select c= new Select(so.country);
		c.selectByValue(readDataFromExcel(1, 13, filePath, sheetName));
		so.state.sendKeys(readDataFromExcel(1, 14, filePath, sheetName));
		so.city.sendKeys(readDataFromExcel(1, 15, filePath, sheetName));
		so.pCode.sendKeys(readDataFromExcel(1, 16, filePath, sheetName));
		so.mbNo.sendKeys(readDataFromExcel(1, 17, filePath, sheetName));
		so.createAccBtn.click();
		elementAvailable(so.accCreatedTxt, true);
		so.continueBtn.click();
		elementAvailable(so.loggedInAs, true);
		so.deleteAcc.click();
		elementAvailable(so.acctDelTxt, true);
		so.continueBtn.click();				
   }
   
   @Test(priority = 2)
   public void RegistUserwithExs() {
	   elementAvailable(so.homepage, true);
		so.SignUpOrLoginbtn.click();
		elementAvailable(so.newUserText, true);
		so.signUpName.sendKeys(readDataFromExcel(2, 1, filePath, sheetName));
		so.signUpEmail.sendKeys(readDataFromExcel(2, 2, filePath, sheetName));
		so.signUpBtn.click();
		elementAvailable(so.signUpCredExist, true);
   }
   
   @AfterSuite
   public void close() {
	  closeApp();
   }
}
