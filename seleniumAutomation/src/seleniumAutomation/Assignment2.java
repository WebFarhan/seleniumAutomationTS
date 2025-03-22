package seleniumAutomation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
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
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().setSize(new Dimension(1500, 921));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']")).sendKeys("Razin Farhan Hussain");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("razin.farhan2018@gmail.com");
		
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("1234");
		
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		
		System.out.println(driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected());
		
		
		driver.findElement(By.xpath("//select[@class='form-control']/option[position()=1]")).click();
		
		driver.findElement(By.xpath("//label[contains(.,'Student')]")).click();
		
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("11/20/1990");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		String successTxt = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		//div[@class='alert alert-success alert-dismissible']
		System.out.println("Submission text: "+successTxt);
		
		System.out.println(successTxt.contains("Success"));

	}

}
