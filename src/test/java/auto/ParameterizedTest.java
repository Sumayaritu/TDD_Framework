package auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Test_Base;

public class ParameterizedTest extends Test_Base {
	@Parameters({"insertEmail1","insertPassword1","insertFirstName1","insertLastName1","insertDOB1"})
	@Test
	public void parameterizedMethod(String insertEmail,String insertPassword,String information,String information1,String information2) {
		homepage.selectMenuBtn();
		signInPage.insertEmail(insertEmail);
		signInPage.insertPassWord(insertPassword);
		signInPage.clickShowPassword();
		signInPage.clickcreatAnewAccountBtn();
		creatAccountPage.insertInformation(information);
		creatAccountPage.insertInformation(information1);
		creatAccountPage.insertInformation(information2);
		creatAccountPage.selectCellNumber("Home");
		
	}
	

}
