package seleniumAutomation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		// TODO Auto-generated method stub
		driver = chromeSetup();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().setSize(new Dimension(1500, 921));
		Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("ban");
		Thread.sleep(3000);
		
		//List<WebElement> options = driver.findElements(By.id("#ui-id-1"));
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class$='ui-menu-item'] a"));
		
		for(WebElement op:options) {
			if(op.getText().equalsIgnoreCase("Bangladesh")) {
				System.out.println(op.getText());
				Assert.assertEquals(op.getText(), "Bangladesh");
				op.click();
				Thread.sleep(4000);
				break;
			}
		}
		
				
		int noOfCheckBox = driver.findElements(By.xpath("//div[contains(@class,'home-Discount')]")).size();

		List<String> checkBoxList = new ArrayList<>();
		List<WebElement> optionsChk = driver.findElements(By.xpath("//div[contains(@class,'home-Discount')]"));
		
		for(WebElement op:optionsChk) {
			System.out.println(op.getText());
			checkBoxList.add(op.getText());
		}
		
		/*
		 List<String> cityList = new ArrayList<>();
		 cityList.add("Delhi");
		 cityList.add("Mumbai");
		 cityList.add("Bangalore");
		 cityList.add("Chennai");
		 cityList.add("Kolkata");
		 cityList.add("Mumbai");
		*/
		 //cityList = cityList.stream().distinct().collect(Collectors.toList());
		 
		 checkBoxList = checkBoxList.stream().distinct().collect(Collectors.toList());
		
		 System.out.println("Refined checkbox list: "+checkBoxList.size());
		
		System.out.println("Number of check boxes in page: "+noOfCheckBox);
		
		//ul[@id='ui-id-1']/li[@class='ui-menu-item']/a[@id='ui-id-79']
		
		
	}
}
