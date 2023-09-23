package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesObjects {

	@FindBy (xpath="//a[text()=' Test Cases']") public WebElement TestCases;
	@FindBy (xpath="//span[contains(text(),'Below is the list of test Cases')]") public WebElement validateTCTxt;
	
	WebDriver driver;
	public TestCasesObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
}
