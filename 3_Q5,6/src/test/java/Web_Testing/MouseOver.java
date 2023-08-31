package Web_Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class MouseOver {

	@Test
	public void testURL() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.automationanywhere.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.xpath("//a[text()='Products']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("(//a[text()='Process Discovery'])[1]")).click();
		String CurrentUrl = driver.getCurrentUrl();
		String expectedURL = "https://www.automationanywhere.com/products/process-discovery";
		
		Assert.assertEquals(CurrentUrl, expectedURL);
		driver.close();

	}

}
