package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\java8\\browser driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//getWindowHandle() handle of single window is a string
		String wid = driver.getWindowHandle();
//		System.out.println(wid);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();// open child window
		
		//getWindowHandles() id of multiple windows a list of strings
		
		Set<String> windids = driver.getWindowHandles();
		// first method === iterators
		
		/* Iterator<String> it = windids.iterator();
		String parentID = it.next();
		String childID = it.next();
		
		System.out.println(parentID);
		System.out.println(childID); */
		
		// second method ==using List/ ArrayList
		
		List<String> windowsIDsList = new ArrayList(windids);  // converting Set ---> List
		
		/* String parentWindowID = windowsIDsList.get(0);
		String childWindowID = windowsIDsList.get(1);
		
		System.out.println("p  "+parentWindowID);
		System.out.println("c  "+childWindowID);
		
		System.out.println(); */ 
		
		// howto use windows IDs for switching
		
		/* driver.switchTo().window(parentWindowID);
		System.out.println("parent tilte  "+ driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(childWindowID);
		System.out.println("child title   "+driver.getTitle());*/
		
		for(String wl:windowsIDsList)
		{
			driver.switchTo().window(wl);
			System.out.println(wl);
			System.out.println(driver.getTitle());
		}
		
	}

}
