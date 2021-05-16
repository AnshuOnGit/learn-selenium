package harshu.learns.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwitterTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankumar\\dev\\learn-selenium\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		Wait<WebDriver> wait = new FluentWait<>(webDriver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		webDriver.get("https://twitter.com/");
		WebElement loginBtn = webDriver.findElement(By.xpath("//*[text() = \"Log in\"]"));
		
		loginBtn.click();
		

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Log in to Twitter\"]")));

		WebElement webElement = webDriver.findElement(By.xpath("//*[@name ='session[username_or_email]']"));
		webElement.sendKeys("anshu_726");
		webElement = webDriver.findElement(By.xpath("//*[@name ='session[password]']"));
		webElement.sendKeys("jmd01123");
		
		webElement = webDriver.findElement(By.xpath("//*[text() = 'Log in']"));	
		webElement.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()=\"Home\"]")));
		webDriver.close();

	}
}
