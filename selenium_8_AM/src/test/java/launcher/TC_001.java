package launcher;

public class TC_001 extends BaseTest {

	public static void main(String[] args) throws Exception 
	{
		launch("chrome");
		navigateToUrl("https://www.amazon.com");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		title = driver.getCurrentUrl();
		
		System.out.println(title);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.quit();
		
		
//		https://github.com/ravilella1234/April2022_8AMSelenumRepo.git

	}

}
