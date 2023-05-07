package auto;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Test_Base;

public class AutoTest extends Test_Base {
	@Test(enabled=false)
	public void orderNowButtonTest() {
		homepage.orderNowButtonValidation();
		//homepage.insertMsgInSrhbar("Medicine");
	}
	
	@Test(enabled=true)
	public void clickCartButtonTest() {
		homepage.clickCartButton();
	}
	
	/*@Test
	public void clickWeeklyAddButtonTest() {
		homepage.clickWeeklyAddButton();
	}
	*/
	
	@Test(enabled=true)
	public void clickContinueShoppingTest() {
	cartpage.clickContinueShopping();
	}
	@Test(enabled=false)
	public void insertMsgInSrhbarTest() {
		homepage.insertMsgInSrhbar("Medicine");
		homepage.clickSearchBtn();
	}
	/*@Test
	public void clickSearchBtnTest() {
		homepage.clickSearchBtn();
	}
*/
}
