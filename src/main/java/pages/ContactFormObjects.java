package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormObjects {

	@FindBy (xpath="//h2[text()='Get In Touch']") public WebElement GetInTch;
	@FindBy (xpath = "//a[text()=' Contact us']") public WebElement ContactUs;
	@FindBy (xpath = "//input[@data-qa='name']") public WebElement ContName;
	@FindBy (xpath = "//input[@data-qa='email']") public WebElement ContEmail;
	@FindBy (xpath = "//input[@data-qa='subject']") public WebElement ContSubj;
	@FindBy (xpath = "//textarea[@id='message']") public WebElement ContMsg;
	@FindBy (xpath = "//input[@name='upload_file']") public WebElement uploadFile;
	@FindBy (xpath = "//input[@name='submit']") public WebElement submitBtn;
	@FindBy (xpath = "(//div[contains(text(),'Success! Your details ')])[1]") public WebElement succMsg;
	@FindBy (xpath = "//a//span[text()=' Home']") public WebElement home;
	
	WebDriver driver;
	
	public ContactFormObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
