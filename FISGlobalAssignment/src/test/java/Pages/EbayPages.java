package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import EbayImplementation.TestCore;

public class EbayPages {
	
	static WebDriver driver=TestCore.getdriver(); 

	
	public static WebElement SearchText() throws Exception {
		return driver.findElement(By.xpath("//*[@class='gh-search']/descendant::div[@id='gh-ac-wrap']/input"));

}
	
	public static WebElement bookClick() {
		
		return driver.findElement(By.xpath("(//*[contains(@class,'srp-results')]/li[1]/descendant::a)[3]/descendant::span"));
	}
	
	public static WebElement AddToCartButton() {
		
		return driver.findElement(By.xpath("//*[contains(text(),'cart')]/parent::span"));
	}
	
public static WebElement ClickAddToCartCross() {
		
		return driver.findElement(By.xpath("//*[contains(text(),'Added')]/ancestor::h2/following-sibling::button"));
	}

public static WebElement CartIcon() {
	
	return driver.findElement(By.xpath("//*[@class=\"gh-cart__icon\"]/descendant::span"));
}


}