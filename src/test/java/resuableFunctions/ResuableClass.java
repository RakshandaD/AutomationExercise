package resuableFunctions;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResuableClass {

	public static final String filePath = "C:\\Users\\raksh\\OneDrive\\Desktop\\AutomationExerciseData.xlsx";
	public static final String sheetName = "Generic";
	   public static WebDriver driver= new EdgeDriver();
	   
	// Method to launch application
		public void launchApp() {
			Reporter.log("=====Browser Session Started=====", true);
			WebDriverManager.edgedriver().setup();
			driver.get(readDataFromExcel(1, 1, filePath, sheetName));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			Reporter.log("=====Application Started=====", true);
		}
		
		// Method to close the brower instance
		public void closeApp() {
			driver.close();
			Reporter.log("=====Browser Session End=====", true);
		}
	   
	   // Method to verify the title is equal to expected title
		public void titleEquals(String expectedTitle) {
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle,"Actual Title is equal to the expected Title(" + expectedTitle + ")");
			System.out.println(actualTitle);
		}

		// Method to verify the innerHtmlText of the single webelement is equal to the expected text
		public void innerTextEquals(WebElement element, String expectedText) {
			String actualText = element.getText();
			assertEquals(actualText, expectedText);
			System.out.println(actualText);
		}
		
		// Method to verify the innerHtmlText of the multiple webelement is equal to the expected text
		public void multipleInnerTextEquals(List<WebElement> element, String expectedText) {
			for(WebElement data: element) {
				String actualText = data.getText();
				assertEquals(actualText, expectedText);	
			}
				
		}

		// Method to verify whether the element is available in the application or not
		public void elementAvailable(WebElement element, boolean expectedValue) {
			boolean actualValue = element.isDisplayed();
			assertEquals(actualValue, expectedValue);
			System.out.println(actualValue);
		}

		// Method to verify whether the element is enabled in the application or not
		public void elementEnabled(WebElement element, boolean expectedValue) {
			boolean actualValue = element.isEnabled();
			assertEquals(actualValue, expectedValue);
		}

		// Method to verify whether the element is selected in the application or not
		public void elementSelected(WebElement element, boolean expectedValue) {
			boolean actualValue = element.isEnabled();
			assertEquals(actualValue, expectedValue);
		}
		
		// Import workbook to get the data from the excel
		public String readDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname)
	    {
	        String data = null;
	        try
	        {
	            FileInputStream input= new FileInputStream(filepath);
	            @SuppressWarnings("resource")
				XSSFWorkbook wb=new XSSFWorkbook(input);
	            XSSFSheet sh=wb.getSheet(Sheetname);
	            XSSFRow row=sh.getRow(rowcount);
	            DataFormatter df = new DataFormatter();
	            data = df.formatCellValue(row.getCell(columncount));
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	        return data;
	     }
}
