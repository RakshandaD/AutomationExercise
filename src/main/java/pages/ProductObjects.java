package pages;

import java.util.List;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductObjects {	
	
	@FindBy(xpath  = "//a[text()=' Products']")public WebElement products;
	@FindBy(xpath  = "//h2[text()='All Products']")public WebElement allProdTxt;
	@FindBy(xpath = "//div[@class='features_items']")public WebElement productlist;
	@FindBy(xpath = "(//a[text()='View Product'])[1]")public WebElement ViewFirstProduct;
	@FindBy (xpath = "//h2[text()='Blue Top']")public WebElement productName;
	@FindBy (xpath = "//p[text()='Category: Women > Tops']")public WebElement prodCategory;
	@FindBy (xpath = "//span[text()='Rs. 500']")public WebElement prodPrice;
	@FindBy (xpath = "//p[text()=' In Stock']")public WebElement ProdAvail;
	@FindBy (xpath = "//p[text()=' New']")public WebElement prodCondition;
	@FindBy (xpath = "//p[text()=' Polo']")public WebElement ProdBrand;
	@FindBy (xpath = "//a[@href='/product_details/1']")public WebElement prodDetailsBtn;
	@FindBy (id = "quantity")public WebElement quantitys;
	@FindBy (xpath = "//button[@class='btn btn-default cart']") public WebElement addToCardBtn;
	
	// Quantity = 4
		@FindBy (xpath = "//button[@class='disabled' and text()='1']")public WebElement quantity4;
	
	//Search Products objects
	@FindBy (id = "search_product")public WebElement searchProd;
	@FindBy (id = "submit_search")public WebElement searchBtn;
	@FindBy (xpath = "//h2[text()='Searched Products']") public WebElement searchedProd;
	
	//Add to cart
	@FindBy(xpath = "//a[@data-product-id='1']/preceding-sibling::img")
	public WebElement firstProdHover;
	@FindBy(xpath = "//div[@class='overlay-content']//a[@data-product-id='1']")
	public WebElement firstProdAddToCart;
	@FindBy(xpath = "//a[@data-product-id='2']/preceding-sibling::img")
	public WebElement secondProdHover;
	@FindBy(xpath = "//div[@class='overlay-content']//a[@data-product-id='2']")
	public WebElement secondProdAddToCart;
	@FindBy (xpath = "(//a[@data-product-id='1'])[1]") public WebElement addfirstProdToCart;
	@FindBy (xpath = "(//a[@data-product-id='2'])[1]") public WebElement addSecProdToCart;
	@FindBy (xpath = "(//button[text()='Continue Shopping'])[1]") public WebElement continueShopp;
	@FindBy (xpath = "(//u[text()='View Cart'])") public WebElement viewCart;
	
	//First Product details in cart
	@FindBy (xpath = "//button[@class='disabled' and text()='1']")public List<WebElement> quantity;
	@FindBy (xpath = "//p[text()='Rs. 500']")public WebElement price;
	@FindBy (xpath = "//img[@src='get_product_picture/1']")public WebElement prodImage;
	@FindBy (xpath = "//p[text()='Women > Tops']")public WebElement productCategory;
	@FindBy (xpath = "//a[text()='Blue Top']")public WebElement prodName;
	@FindBy (xpath = "//p[@class='cart_total_price' and text()='Rs. 500']")public WebElement totalPrice;
	@FindBy (xpath = "//a[@class='cart_quantity_delete' and @data-product-id='1']/i")public WebElement deleteItems;
	@FindBy (xpath = "//p[@class='text-center']")public WebElement emptyCart;
	
	//Second Product details in cart
	@FindBy (xpath = "//p[text()='Rs. 400']")public WebElement secPrice;
	@FindBy (xpath = "//img[@src='get_product_picture/2']")public WebElement SecProdImage;
	@FindBy (xpath = "//p[text()='Men > Tshirts']")public WebElement secProdCategory;
	@FindBy (xpath = "//a[text()='Men Tshirt']")public WebElement secProdName;
	@FindBy (xpath = "//p[@class='cart_total_price' and text()='Rs. 400']")public WebElement secTotalPrice;
	@FindBy (xpath = "//a[@class='cart_quantity_delete' and @data-product-id='2']/i")public WebElement secDeleteItems;
	
	WebDriver driver;
	public ProductObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
