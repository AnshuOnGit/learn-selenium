package harshu.learns.testing;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonLoginTest {
	
	@BeforeSuite
	public void beforesuitemethod() {
		System.out.println("I am running before suite");
	}
  @Test(dataProvider = "usernameAndPasswordProvider")
  public void loginTestChrome(String username, String password) {
	  System.setProperty("webdriver.chrome.driver", "/home/anshu/Desktop/selenium_installables/chromedriver_2");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();

		webDriver.get("https://amazon.in/");
		
		Actions action = new Actions(webDriver);

		action.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]")))
				.click().build().perform();
		webDriver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(username);
		webDriver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
		webDriver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		assertTrue(webDriver.getTitle().contains("Amazon.in"),"Invalid Credential");
		webDriver.close(); 
  }
  
  
 
  @Test(dataProvider = "usernameAndPasswordProvider")
  public void loginTestFirefox(String username, String password) {
	  System.setProperty("webdriver.gecko.driver", "/home/anshu/Desktop/selenium_installables/mozilla_driver/geckodriver");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		//webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(webDriver,20);
		
		

		webDriver.get("https://amazon.in/");
		
		
		Actions action = new Actions(webDriver);
		
		

		action.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]")))
				.click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ap_email\"]")));
		
		
		webDriver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(username);
		webDriver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
		webDriver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		assertTrue(webDriver.getTitle().contains("Amazon.in"),"Invalid credential");
		System.out.println("User is able to login successfully");
		webDriver.close(); 
  }


  @DataProvider
  public Object[][] usernameAndPasswordProvider() throws Exception {
	  Object[][] testObjArray = ExcelUtil.
			  getTableArray("/home/anshu/Documents/eclipse-workspace/selenium-amazon/src/test/resources/TestSheet.xlsx","Sheet1");
	  
      return (testObjArray); 
	  
/*    return new Object[][] {
      new Object[] { "anshu.kumar726@gmail.com", "punewagholi123" },
      new Object[] { "harshitapatel21792@gmail.com", "Hansh2126#" },
      new Object[] { "harshitapatel21792@gmail.com", "hanshu20" },
    };*/
  }


}
