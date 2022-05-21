package launcher;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher {

	public static void main(String[] args) 
	{
//		WebDriverManager.chromedriver().setup();
		//System.setProperty("WebDriver.chrome.driver", "");
//		WebDriver driver = new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
		
		driver.findElement(By.xpath("//button[@aria-label='No thanks']")).click();
		
		driver.switchTo().parentFrame();
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("java selenium");
		search.sendKeys(Keys.ENTER);
		

	}

}
