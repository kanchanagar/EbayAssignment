package CommonUtils;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import EbayImplementation.TestCore;
import Listener.ExtentReportListener;



public class commonutils extends ExtentReportListener {
	
	public static WebDriver driver=TestCore.getdriver();
	
		public static WebElement ExplicitlyWait(String path) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

		}
		
		public static Boolean ExplicitlyWaitIdElementToBeInvisible(String path) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(path)));

		}

		public static WebElement ExplicitlyWaitXpath(String path) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

		}
		
		
		public static void TakeScreenshot(String methodName) throws Throwable {
			String Screenshotpath = System.getProperty("user.dir") + "/src/test/java/Screenshots/";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenShot_Path = (Screenshotpath+ methodName +"_" + ".png");
			FileUtils.copyFile(scrFile, new File(screenShot_Path));

			System.out.println("Taking Screenshot for Local Machine " + screenShot_Path);
		
			
		}
		
		// Focusing element including click and sendkeys
		public static void actionFocus1(WebElement element, String keys) {
			Actions action = new Actions(driver);
			action.moveToElement(element);
			action.click();
			action.sendKeys(keys);
			action.keyDown(Keys.ENTER);
			action.build().perform();
		}
		
		
		public static String SwitchToWindow() throws InterruptedException {
			Set<String> window= driver.getWindowHandles();
			Iterator<String> it=window.iterator();
			String Parentwindow=it.next();
			String childwindow=it.next();
			
			driver.switchTo().window(childwindow);
			System.out.println(driver.getTitle());
			return driver.getTitle();
			
		}
		
		public static void javascript(WebElement elem) throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", elem);

		}
		
		

	
	
	

}
