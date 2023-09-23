package testcases;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;
import pages.ProductObjects;
import pages.SignUpObjects;
import resuableFunctions.ResuableClass;

public class VerifyProduct extends ResuableClass {
	
	ProductObjects po= new ProductObjects(driver);
	SignUpObjects so= new SignUpObjects(ResuableClass.driver);
	 
	 @BeforeTest
	   public void startUp() throws Exception {
		   launchApp();
	   }
	 
	 @Test(priority = 1)
	 public void VerifyProducts() {
		 elementAvailable(so.homepage, true);
		 po.products.click();
		 System.out.println(driver.getTitle());
		 elementAvailable(po.allProdTxt, true);
		 elementAvailable(po.productlist, true);
		 po.ViewFirstProduct.click();
		 System.out.println(driver.getTitle());
		 elementAvailable(po.productName, true);
		 elementAvailable(po.prodCategory, true);
		 elementAvailable(po.prodPrice, true);
		 elementAvailable(po.ProdAvail, true);
		 elementAvailable(po.prodCondition, true);
		 elementAvailable(po.ProdBrand, true);
		 
	 }
	 
	 @Test(priority = 2)
	 public void searchProduct() {
		 elementAvailable(so.homepage, true);
		 po.products.click();
		 elementAvailable(po.allProdTxt, true);
		 po.searchProd.sendKeys("tshirt");
		 po.searchBtn.click();
		 elementAvailable(po.productlist, true);
		 innerTextEquals(po.searchedProd, "SEARCHED PRODUCTS");
	 }
	 
	 @Test(priority = 3)
	 public void addFirstAndSecondProductsToCart() {
		 elementAvailable(so.homepage, true);
		 po.products.click();
		Actions a = new Actions(driver);
		a.moveToElement(po.firstProdHover).build().perform();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(po.firstProdAddToCart));
		po.firstProdAddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(po.continueShopp));
		po.continueShopp.click();
		
		//Add second product to cart
		a.moveToElement(po.secondProdHover).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(po.secondProdAddToCart));
		po.secondProdAddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(po.viewCart));
		po.viewCart.click();
		verifyProducts();

	 }
	 
	 @Test(priority = 4,description = "Testcases no: 13")
	 public void verifyProdQuantity() {
		 elementAvailable(so.homepage, true);
		 po.prodDetailsBtn.click();
		 po.quantitys.sendKeys("4");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(po.addToCardBtn));
		 po.addToCardBtn.click();
		 wait.until(ExpectedConditions.elementToBeClickable(po.viewCart));
		 po.viewCart.click();
		 WebElement actualQ4 = po.quantity4;
		 String expectedQ4 = "4";
		 innerTextEquals(actualQ4, expectedQ4);
	 }
	 
	 public void verifyProducts() {
			// Verify first product
			WebElement actualPrice = po.price;
			
			String expectedPrice = "Rs. 500";
			innerTextEquals(actualPrice, expectedPrice);
					
			elementAvailable(po.prodImage, true);
					
			WebElement actualProdCategory = po.productCategory;
			String expectedProdCategory = "Women > Tops";
			innerTextEquals(actualProdCategory, expectedProdCategory);
					
			WebElement actualProdName = po.prodName;
			String expectedProdName = "Blue Top";
			innerTextEquals(actualProdName, expectedProdName);
					
			WebElement actualTotal = po.totalPrice;
			String expectedTotal = "Rs. 500";
			innerTextEquals(actualTotal, expectedTotal);
					
			// Verify second product
			WebElement secondProdActualPrice = po.secPrice;
			String secondProdexpectedPrice = "Rs. 400";
			innerTextEquals(secondProdActualPrice, secondProdexpectedPrice);
							
			elementAvailable(po.SecProdImage, true);
							
			WebElement secondProdactualProdCategory = po.secProdCategory;
			String secondProdexpectedProdCategory = "Men > Tshirts";
			innerTextEquals(secondProdactualProdCategory, secondProdexpectedProdCategory);
							
			WebElement secondProdactualProdName = po.secProdName;
			String secondProdexpectedProdName = "Men Tshirt";
			innerTextEquals(secondProdactualProdName, secondProdexpectedProdName);
							
			WebElement secondProdactualTotal = po.secTotalPrice;
			String secondProdexpectedTotal = "Rs. 400";
			innerTextEquals(secondProdactualTotal, secondProdexpectedTotal);
					
			for(WebElement data: po.quantity) {
				String expectedQuantity = "1";
			    innerTextEquals(data, expectedQuantity);
			}
		}
	
	 @AfterSuite
	   public void close() {
		  closeApp();
	   }

}
