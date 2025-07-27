package EbayImplementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Listener.ExtentReportListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCore {

	private static TestCore base=null;
	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadlocal = new ThreadLocal<WebDriver>();
 
	private TestCore(){
		
	}
	
	public static void Setup() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/properties.config";
		FileInputStream fis = new FileInputStream(path);

		Properties prop = new Properties();
		prop.load(fis);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			threadlocal.set(driver);
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			threadlocal.set(driver);
		}

		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static WebDriver getdriver() {
		
		if(threadlocal.get()==null) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		return threadlocal.get();
		
		
		
		
		
	}
	
	
	public static TestCore getInstance() throws IOException {
		if(base ==null) {
			base=new TestCore();
		}
		if(threadlocal.get()==null) {
			base.Setup();
		}
		
		return base;
	}


	public static void tearDown() {
		driver.close();
	}

}
