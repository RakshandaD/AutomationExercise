package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {

	@FindBy (xpath="//a[text()=' Home']") public WebElement homepage;
	@FindBy (xpath = "//a[text()=' Signup / Login']") public WebElement SignUpOrLoginbtn;
	@FindBy (xpath="//h2[text()='Login to your account']") public WebElement LoginToAccTxt;
	@FindBy (xpath="//input[@data-qa='login-email']") public WebElement loginEmail;
	@FindBy (xpath="//input[@data-qa='login-password']") public WebElement loginpass;
	@FindBy (xpath="//button[@data-qa='login-button']") public WebElement Loginbtn;
	@FindBy (xpath="//a[text()=' Logged in as ']") public WebElement loggeInAs;
	@FindBy (xpath="//a[text()=' Delete Account']") public WebElement delAcc;
	@FindBy (xpath="//b[contains(text(),'Account Deleted!')]") public WebElement acctDelTxt;
	@FindBy (xpath="//p[contains(text(),'is incorrect!')]") public WebElement IncorrCredTxt;
	@FindBy (xpath="//a[text()=' Logout']") public WebElement logout;
	
	WebDriver driver;
	public LoginObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
