package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ContactFormObjects;
import pages.SignUpObjects;
import resuableFunctions.ResuableClass;

public class ContactForm extends ResuableClass{

	ContactFormObjects co= new ContactFormObjects(ResuableClass.driver);
	SignUpObjects so= new SignUpObjects(ResuableClass.driver);
	 
	 @BeforeTest
	   public void startUp() throws Exception {
		   launchApp();
	   }
	 
	 @Test
	 public void ContactTest() throws Exception {
		 elementAvailable(so.homepage, true);
		 co.ContactUs.click();
		 elementAvailable(co.GetInTch, true);
		 co.ContName.sendKeys("Rakshanda");
		 co.ContEmail.sendKeys("rakshanda1710@gmail.com");
		 co.ContSubj.sendKeys("Test Subject");
		 co.ContMsg.sendKeys("Test Message");
		// co.uploadFile.sendKeys("C:\\Users\\raksh\\OneDrive\\Desktop\\SeleniumExcel.xlsx");
		 Robot rb= new Robot();
		 StringSelection str = new StringSelection("C:\\Users\\raksh\\OneDrive\\Desktop\\SeleniumExcel.xlsx");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	     // release Contol+V for pasting
	     rb.keyRelease(KeyEvent.VK_CONTROL);
	     rb.keyRelease(KeyEvent.VK_V);	  
	     // for pressing and releasing Enter
	     rb.keyPress(KeyEvent.VK_ENTER);
	     rb.keyRelease(KeyEvent.VK_ENTER);
		 co.submitBtn.click();
		 Alert alert= driver.switchTo().alert();
		 alert.accept();
		 elementAvailable(co.succMsg, true);
		 co.home.click();
		 elementAvailable(so.homepage, true);
		 titleEquals("Automation Exercise");
		
	 }
	 
	 @AfterSuite
	   public void close() {
		  closeApp();
	   }
}
