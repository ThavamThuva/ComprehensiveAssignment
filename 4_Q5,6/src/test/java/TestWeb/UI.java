package TestWeb;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UI {

	@Test
	public void testURL() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.automationanywhere.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		
		/* a. Click on Request Demo button */
		driver.findElement(By.xpath("//a[@class=\"coh-link utility-nav-link coh-style-solid-orange-button\"]")).click();
		
		/* b. Verify that page is navigated */
		String ActualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.automationanywhere.com/request-live-demo";
		
		Assert.assertEquals(expectedURL, ActualURL);
		Assert.assertEquals(ActualURL, expectedURL, "page is navigated to https://www.automationanywhere.com/request-live-demo");
	}
	@Test
	public void testText() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.automationanywhere.com/");
		driver.manage().window().maximize();
		
		/* c. Verify the Label Names for First Name and Last Name */
		String firstNameLabel = driver.findElement(By.xpath("//label[@class=\"mktoLabel mktoHasWidth\"]")).getText();
		String firstName = "First Name";
		String lastNameLabel = driver.findElement(By.xpath("//label[@class=\"mktoLabel mktoHasWidth\"]")).getText();
		String lastName = "Last Name";
		
		Assert.assertEquals(firstNameLabel, firstName);
		Assert.assertEquals(lastNameLabel, lastName);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.close();

	}

}
