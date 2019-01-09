package harshu.learns.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TimesofIndia {
  @Test
  public void toi() {
	  System.setProperty("webdriver.chrome.driver", "/home/anshu/Desktop/selenium_installables/chromedriver_2");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		//webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Implicit wait */

		webDriver.get("https://timesofindia.indiatimes.com/");
		Actions action = new Actions(webDriver);

		 //Thread.sleep(10000);/*crude wait --not recommended*/

		WebDriverWait wait = new WebDriverWait(webDriver, 20);

		
		
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(webDriver)							
				.withTimeout(Duration.ofSeconds(30)) 			
				.pollingEvery(Duration.ofSeconds(5)) 			
				.ignoring(NoSuchElementException.class);
		
		
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-nav\"]/ul/li[3]/a")));
		

		action.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"main-nav\"]/ul/li[3]/a"))).click().build()
				.perform();

		webDriver.close();
  }
}
