package harshu.learns.testing;

import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests {
	
	private WebDriver webDriver;
	private Wait<WebDriver> wait;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankumar\\dev\\learn-selenium\\chromedriver.exe");
		
	}
	
	@BeforeMethod
	public void setUpBeforeEachTest() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		wait = new FluentWait<>(webDriver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
	}
	
	@AfterTest
	public void wrapUpAfterEachMethod() {
		webDriver.close();
	}
	
	@Test
	public void loginToTwitter() {
		webDriver.get("https://twitter.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = \"Log in\"]")));
		WebElement loginBtn = webDriver.findElement(By.xpath("//*[text() = \"Log in\"]"));
		loginBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Log in to Twitter\"]")));

		WebElement webElement = webDriver.findElement(By.xpath("//*[@name ='session[username_or_email]']"));
		webElement.sendKeys("anshu_726");
		webElement = webDriver.findElement(By.xpath("//*[@name ='session[password]']"));
		webElement.sendKeys("jmd01123");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = \"Log in\"]")));
		webElement = webDriver.findElement(By.xpath("//*[text() = 'Log in']"));	
		webElement.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Home\"]")));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'Anshu Kumar')]")));
		//assertNotNull(webDriver.findElement(By.xpath("//img[contains(@alt,'Anshu Kumar')]")));
	}
	
	@Test
	public void loginAmazon() {

		webDriver.get("https://amazon.in/");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Hello, Sign in']")));
		WebElement webElement = webDriver.findElement(By.xpath("//*[text()='Hello, Sign in']"));
        webElement.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"ap_email\"]")));
		webDriver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("anshu.kumar726@gmail.com");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"continue\"]")));
		webDriver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"ap_password\"]")));
		webDriver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Hansh2126!");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"signInSubmit\"]")));
		webDriver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
	}
	

}
