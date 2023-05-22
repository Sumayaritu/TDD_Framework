package auto;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Test_Base;
import object.SignInPage;

public class AutoTest extends Test_Base {
	
	@Test
	public void selectMenuBtnTest() {
		homepage.selectMenuBtn();
		signInPage.insertEmail("tdd@gmail.com");
		signInPage.insertPassWord("12345");
		signInPage.clickShowPassword();
		signInPage.clickcreatAnewAccountBtn();
		creatAccountPage.validateTitle("Create your account");
		creatAccountPage.insertInformation("Claudia");
		creatAccountPage.insertInformation("Suarez");
		creatAccountPage.insertInformation("07.10.1998");
		creatAccountPage.selectCellNumber("Home");
		creatAccountPage.insertInformation("tdd@gmail.com");
		creatAccountPage.insertInformation("C12345678");
		creatAccountPage.clickShowPassword();
		creatAccountPage.clickShowPassword();
		creatAccountPage.clickContinueBtn(driver);
	}
	@Test
	public void clickFind_A_Store_Test() {
		homepage.clickFind_A_Store();
	}
	@Test
	public void clickFind_Care_Btn_Test() {
		homepage.clickFind_Care_Btn();
	}
	
}
