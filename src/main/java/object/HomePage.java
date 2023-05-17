package object;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import static common.CommonAction.*;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class=\"menu-trigger\"]")
	WebElement MenuBtn;
			
	//@FindBy(xpath = "//span[text()='Find a Store']")
	//WebElement findAStore;
	
	@FindBy(xpath="//span[text()='Prescriptions']")
	WebElement prescriptionBtn;
	
	@FindBy(xpath="//a[@id=\"records\"]")
	WebElement recordsBtn;
	
	public void selectMenuBtn() {
		click(MenuBtn);
		//click(findAStore);
		click(prescriptionBtn);
		click(recordsBtn);
	}
	
	@FindBy(xpath="//a[@id=\'wag-cart-no-item-link\']")
	WebElement ContinueShopping;
	
	public void clickContinueShopping() {
		ContinueShopping.click();
	}
	 
			
	

}
