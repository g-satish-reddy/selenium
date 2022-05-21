package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action {

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
//		driver.get("https://www.spicejet.com/");
//		Thread.sleep(3000);
//		WebElement addon = driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(addon).build().perform();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//div[contains(text(),'Hot Meals')]")).click();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement from = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='box103']"));
		
		Actions act = new Actions(driver);
//		act.dragAndDrop(from, to).perform();
		
		act.clickAndHold(from).moveToElement(to).release().build().perform();
		
		act.keyDown(Keys.SHIFT);
		
		
		
		

	}

}
