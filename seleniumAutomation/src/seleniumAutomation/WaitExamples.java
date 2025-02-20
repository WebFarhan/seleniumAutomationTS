package seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		explicitWaitExample();
		CusomWaitExample();
	}
	
	private static void CusomWaitExample() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://trainingbypackt.github.io/Beginning-Selenium/lesson_5/activity_5_A-1.html");
		try {
			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("runTestButton"));
				}
			
			});
			
			if(element.getDomAttribute("id").equals("runTestButton")) {
				System.out.println("We have successfully found");
			}
			else {
				System.out.println("No success");
			}
		} finally {
			driver.quit();
		}
	}
	
	
	private static void explicitWaitExample() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://trainingbypackt.github.io/Beginning-Selenium/lesson_5/activity_5_B-1.html");
        try {
            /* Search for a button named runTestButton and click on it to start the test*/
            driver.findElement(By.id("runTestButton")).click();

            // Set an explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.titleContains("Explicit"));

            // Verify expected changes
            if (driver.getTitle().startsWith("Explicit")) {
                System.out.println("ExplicitWait worked, the element contains 'Explicit'");
            } else {
                System.out.println("Something went wrong with ExplicitWait, 'Explicit' was not found");
            }
        } finally {
            driver.quit();
        }
    }
	

}
