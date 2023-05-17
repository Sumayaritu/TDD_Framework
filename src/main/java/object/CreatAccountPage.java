package object;

import static common.CommonAction.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class CreatAccountPage {
	public CreatAccountPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//h1[text()='Create your account']")
	WebElement title;
	
	@FindBy(id="wag-RXUser-firstname")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(id="wag-RXUser-DOB")
	WebElement dateOfBirth;
	
	@FindBy(id="wag-phonetype-select")
	WebElement cell;
	
	public void validateTitle(String expected) {
		Assert.assertEquals(getText(title), expected);
	}
	public void insertInformation(String msg) {
		insert(firstName,msg);
		insert(lastName, msg);
		insert(dateOfBirth, msg);
	}
	public void selectCellNumber(String msg) {
		dropdown(cell,msg);
	}

}
