package harshu.learns.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenAmazon {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankumar\\dev\\learn-selenium\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();

		webDriver.get("https://amazon.in/");
		
		Actions action = new Actions(webDriver);
		//#icp-nav-flyout
		//#nav-link-accountList
		
		
      //  WebElement webElement = webDriver.findElement(By.id("nav-link-accountList"));
		WebElement webElement = webDriver.findElement(By.xpath("//*[text()='Hello, Sign in']"));
		action.moveToElement(webElement)
				.click().build().perform();
		webDriver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("anshu.kumar726@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hansh2126!");
		webDriver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		
		

		Thread.sleep(200000);
		webDriver.close();
	}

}
