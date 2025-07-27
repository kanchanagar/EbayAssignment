package EbayImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonUtils.RetryAnalyzer;
import CommonUtils.commonutils;
import Pages.EbayPages;

public class ebayImplementation {

	static WebDriver driver;

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "Smoke", priority = 1)
	public static void LaunchingtheURL() throws Throwable {

		Thread.sleep(2000);
		driver = TestCore.getInstance().getdriver();
		commonutils.TakeScreenshot("Navigation to Ebay application");

	}

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "Smoke", priority = 2)
	public static void EbaySearchBook() throws Throwable {

		Thread.sleep(2000);
		commonutils.actionFocus1(EbayPages.SearchText(), "books");
		commonutils.TakeScreenshot("Ebay Search Book");

	}

	@Test(retryAnalyzer = RetryAnalyzer.class, groups = "Smoke", priority = 3)
	public static void SelectingthebookandAddToCartandValidate() throws Throwable {

		Thread.sleep(2000);
		EbayPages.bookClick().click();
		Thread.sleep(2000);
		commonutils.SwitchToWindow();
		Thread.sleep(2000);

		WebElement elem = EbayPages.AddToCartButton();
		commonutils.javascript(elem);
		Thread.sleep(2000);
		EbayPages.AddToCartButton().click();
		
		Thread.sleep(2000);
		EbayPages.ClickAddToCartCross().click();

		Thread.sleep(2000);
		WebElement elem1 = EbayPages.CartIcon();
		commonutils.javascript(elem1);
		
		

		System.out.println(elem1.getText());

		if (elem1.getText().contains("1")) {
			System.out.println("Item is added to the cart");
			commonutils.TakeScreenshot("Ebay Cart Icon");
		} else {
			System.out.println("failed to add item to the cart");
			commonutils.TakeScreenshot("Failed Ebay Cart Icon");
		}

	}

}
