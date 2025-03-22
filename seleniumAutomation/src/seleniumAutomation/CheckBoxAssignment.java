package seleniumAutomation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxAssignment {
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

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		return driver;
	}

	public static void main(String[] args) throws InterruptedException {
		driver = chromeSetup();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().setSize(new Dimension(1500, 921));
		
		
		Thread.sleep(3000);
		Boolean chkFlag = driver.findElement(By.cssSelector("label[for='bmw'] input[id='checkBoxOption1']")).isSelected();

		if(chkFlag == true) {
			System.out.println("First checkbox checked");
		}else {
			System.out.println("First checkbox unchecked");
			driver.findElement(By.cssSelector("label[for='bmw'] input[id='checkBoxOption1']")).click();
			Assert.assertTrue(driver.findElement(By.cssSelector("label[for='bmw'] input[id='checkBoxOption1']")).isSelected());
		}
		
		Thread.sleep(2000);
		if(driver.findElement(By.cssSelector("label[for='bmw'] input[id='checkBoxOption1']")).isSelected() == true) {
			driver.findElement(By.cssSelector("label[for='bmw'] input[id='checkBoxOption1']")).click();//uncheck
			Assert.assertFalse(driver.findElement(By.cssSelector("label[for='bmw'] input[id='checkBoxOption1']")).isSelected());
		}
		
		
		List<WebElement> numOfCheckBoxes = driver.findElements(By.xpath("//div[@id='checkbox-example']//fieldset/label"));
		
		System.out.println("Number of check boxes: "+numOfCheckBoxes.size());
		Assert.assertEquals(numOfCheckBoxes.size(), 3);
		
	}

}
