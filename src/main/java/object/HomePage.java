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
	
	@FindBy(xpath="//a[@class=\'CA__mb-15\']")
	WebElement OrdernowButton;
	
	@FindBy(xpath="//*[@id='pf-icon__cart']")
	WebElement CartButton;
	
	@FindBy(xpath="//input[@id=\'ntt-placeholder\']")
	WebElement SearchBar;
	
	@FindBy(xpath="//*[@id=\"pf-icon__search\"]")
	WebElement SearchBtn;
			
	
	public void orderNowButtonValidation() {
		getInnerHTML(OrdernowButton);
	}
	
	public void clickCartButton() {
		CartButton.click();
	}
	
	public void insertMsgInSrhbar(String msg) {
		insert(SearchBar,msg);
}
	public void clickSearchBtn() {
		SearchBtn.click();
	}
	
	/*@FindBy(xpath="//*[@id=\'Default_Left_Slot_New_a_CB-2\']")
	WebElement WeeklyAddButton;
	
	public void clickWeeklyAddButton() {
		WeeklyAddButton.click();
	}
	*/
	
	@FindBy(xpath="//a[@id=\'wag-cart-no-item-link\']")
	WebElement ContinueShopping;
	
	public void clickContinueShopping() {
		ContinueShopping.click();
	}
	 
			
	

}
