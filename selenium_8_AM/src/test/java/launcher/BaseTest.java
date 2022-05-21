package launcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String Projectpath = System.getProperty("user.dir");
	public static Properties p;
	public static Properties mainprop;
	public static Properties childprop;
	public static FileInputStream fis;
	
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(Projectpath+"/src/test/resources/environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);
		String e = mainprop.getProperty("env");
		
		fis = new FileInputStream(Projectpath+"/src/test/resources/"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		
		
		fis = new FileInputStream(Projectpath+"/src/test/resources/data.properties");
		p = new Properties();
		p.load(fis);
	
	}

	public static void launch(String browserkey) 
	{
		if (p.getProperty(browserkey).equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=C:\\Users\\Asus\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
			options.addArguments("--disable-notifications");
			options.addArguments("--ignore-certificate-errors");
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if(p.getProperty(browserkey).equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("AprilFFProfile");
			
			//handling notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//handling certificate errors
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			//working with proxy settings
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.10.1");
			profile.setPreference("network.proxy.socks_port", 1744);
			
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		}
		else if(p.getProperty(browserkey).equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	}
	
	
	public static void navigateToUrl(String urlkey)
	{
		driver.get(childprop.getProperty(urlkey));
	}

}
