package harshu.learns.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenAmazon {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/anshu/Desktop/selenium_installables/chromedriver_2");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();

		webDriver.get("https://amazon.in/");
		
		Actions action = new Actions(webDriver);

		action.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]")))
				.click().build().perform();
		webDriver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("anshu.kumar726@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		webDriver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("punewagholi123");
		webDriver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		
		

		Thread.sleep(2000);
		webDriver.close();
	}

}
