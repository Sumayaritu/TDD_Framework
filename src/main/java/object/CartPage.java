package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id=\'wag-cart-empty-lbl\']")
	WebElement ContinueShopping;
	
	public void clickContinueShopping() {
		ContinueShopping.click();
	}

}
