import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UI {

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tthavarasa\\OneDrive - Virtusa\\Desktop\\Exam\\BrowserDrivers\\chromedriver.exe");
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
		
		if(ActualURL.equals(expectedURL)) {
			System.out.println("User navigate correct URL.");
		}else {
			System.out.println("User navigate to wrong URL.");
		}
		
		String firstNameLabel = driver.findElement(By.xpath("//label[@class=\"mktoLabel mktoHasWidth\"]")).getText();
		String firstName = "First Name";
		String lastNameLabel = driver.findElement(By.xpath("//label[@class=\"mktoLabel mktoHasWidth\"]")).getText();
		String lastName = "Last Name";
		
		if(firstNameLabel.equals(firstName) && lastNameLabel.equals(lastName)) {
			System.out.println("Label Names are correct. ");
		}else {
			System.out.println("Label Names are not correct.");
		}
		driver.close();

	}

}
