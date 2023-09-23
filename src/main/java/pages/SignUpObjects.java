package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpObjects {

	@FindBy (xpath="//a[text()=' Home']") public WebElement homepage;
	@FindBy (xpath="//h2[text()='New User Signup!']") public WebElement newUserText;
	@FindBy (xpath="//input[@data-qa='signup-name']") public WebElement signUpName;
	@FindBy (xpath = "//input[@data-qa='signup-email']") public WebElement signUpEmail;
	@FindBy (xpath="//button[@data-qa='signup-button']") public WebElement signUpBtn;
	@FindBy (xpath="//b[text()='Enter Account Information']") public WebElement accntInfoTxt;
	@FindBy (id ="id_gender1") public WebElement gender1;
	@FindBy (id ="id_gender2") public WebElement gender2;
	@FindBy (xpath="//input[@id='name']") public WebElement accName;
	@FindBy (xpath="//input[@id='email']") public WebElement accEmail;
	@FindBy (xpath="//input[@id='password']") public WebElement accPwd;
	@FindBy (id = "days") public WebElement dobDay;
	@FindBy (id="months") public WebElement dobMon;
	@FindBy (id="years") public WebElement dobYr;
	@FindBy (id = "newsletter") public WebElement news;
	@FindBy (id="optin") public WebElement offer;
	@FindBy (id="first_name") public WebElement fName;
	@FindBy (id="last_name") public WebElement lName;
	@FindBy (id="company") public WebElement company;
	@FindBy (id = "address1") public WebElement addr1;
	@FindBy (id="address2") public WebElement add2;
	@FindBy (id="country") public WebElement country;
	@FindBy (id="state") public WebElement state;
	@FindBy (id="city") public WebElement city;
	@FindBy (id="zipcode") public WebElement pCode;
	@FindBy (id = "mobile_number") public WebElement mbNo;
	@FindBy (xpath="//button[@data-qa='create-account']") public WebElement createAccBtn;
	@FindBy (xpath="//b[text()='Account Created!']") public WebElement accCreatedTxt;
	@FindBy (xpath = "//a[text()='Continue']") public WebElement continueBtn;
	@FindBy (xpath="//a[contains(text(),' Logged in as ')]") public WebElement loggedInAs;
	@FindBy (xpath = "//a[contains(text(),' Delete Account')]") public WebElement deleteAcc;
	@FindBy (xpath="//b[contains(text(),'Account Deleted!')]") public WebElement acctDelTxt;
	@FindBy (xpath = "//a[text()=' Signup / Login']") public WebElement SignUpOrLoginbtn;
	@FindBy (xpath = "//p[contains(text(),'already exist!')]") public WebElement signUpCredExist;
	
	WebDriver driver;
	
	public SignUpObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
