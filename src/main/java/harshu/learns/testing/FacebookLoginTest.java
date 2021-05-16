package harshu.learns.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FacebookLoginTest {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankumar\\dev\\learn-selenium\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();

		webDriver.get("https://facebook.com/");
		
		Actions action = new Actions(webDriver);
		//#icp-nav-flyout
		//#nav-link-accountList
		
		
      //  WebElement webElement = webDriver.findElement(By.id("nav-link-accountList"));
		WebElement webElement = webDriver.findElement(By.xpath("//*[@placeholder ='Email address or phone number']"));
		webElement.sendKeys("anshu2cool09@yahoo.com");
		webElement = webDriver.findElement(By.xpath("//*[@placeholder ='Password']"));
		webElement.sendKeys("wasteoftime123");
		webElement = webDriver.findElement(By.xpath("//*[text() ='Log In']"));
		action.moveToElement(webElement)
		.click().build().perform();
		Thread.sleep(200000);
		webDriver.close();
	}

}
