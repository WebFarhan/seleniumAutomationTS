package seleniumAutomation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDown {
	public static WebDriver  driver;
	
	public static WebDriver chromeSetup() {
		// Create a map to store preferences
		Map<String, Object> prefs = new HashMap<String, Object>();

		// add key and value to map as follow to switch off browser notification
		// Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Create an instance of ChromeOptions
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs
		options.setExperimentalOption("prefs", prefs);

		// Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize
		// chrome driver which will switch off this browser notification on the chrome
		// browser
		// WebDriver driver = new ChromeDriver(options);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		return driver;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = chromeSetup();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().setSize(new Dimension(1500, 921));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-u8s1d r-8fdsdq']//div[contains(text(),'BLR')]
		
		//driver.findElement(By.xpath("//div[contains(text(),'BLR')]")).click();
		
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-u8s1d r-8fdsdq']//div[contains(text(),'BLR')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();

	}

}
