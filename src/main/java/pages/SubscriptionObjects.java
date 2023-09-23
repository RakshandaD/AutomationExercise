package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionObjects {

	@FindBy(id = "susbscribe_email")public WebElement subsEmail;
	@FindBy(id = "subscribe")public WebElement subsBtn;
	@FindBy(xpath = "//h2[text()='Subscription']")public WebElement subscribTxt;
	@FindBy (xpath = "//div[text()='You have been successfully subscribed!']")public WebElement subscriptionAlert;
	@FindBy (xpath = "//a[text()=' Cart']")public WebElement cart;
	@FindBy (xpath = "//span[text()='Required']")public List<WebElement> multipleblankfield_errormessage;
	@FindBy (xpath = "//p[@class='oxd-userdropdown-name']")public WebElement user_dropDown;
	@FindBy (xpath = "//a[text()='Logout']")public WebElement logout;
	
	WebDriver driver;
	public SubscriptionObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
