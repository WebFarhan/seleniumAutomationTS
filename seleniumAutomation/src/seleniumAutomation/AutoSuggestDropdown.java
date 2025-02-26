package seleniumAutomation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {
	
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
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().setSize(new Dimension(1500, 921));
		Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("ban");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement op:options) {
			if(op.getText().equalsIgnoreCase("Bangladesh")) {
				op.click();
				Assert.assertEquals(op.getText(), "Bangladesh");
				break;
			}
		}
		
		
		Boolean chkFlag = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		System.out.println("Before "+chkFlag);
		
		
		Assert.assertFalse(chkFlag);
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		chkFlag = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		System.out.println("After "+chkFlag);
		
		Assert.assertTrue(chkFlag);
		
		int noOfCheckBox = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		
		System.out.println("Number of check boxes in page: "+noOfCheckBox);
		
		//ul[@id='ui-id-1']/li[@class='ui-menu-item']/a[@id='ui-id-79']
		
	}

}
