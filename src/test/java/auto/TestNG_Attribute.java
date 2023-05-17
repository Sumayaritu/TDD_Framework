package auto;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.annotations.Test;



import report.Log;
import retry.RetryTest;

public class TestNG_Attribute {
	@Test(groups = {"testng","unit1"})
	public void test1() {
		Log.log("This is Test1");
	}
	@Test(groups = {"testng","unit2"})
	public void test2() {
		Log.log("This is Test2");
		AssertJUnit.fail();
	}
	@Test(groups ="unit1",dependsOnMethods = "test2",ignoreMissingDependencies = true)
	public void test3() {
		Log.log("This is Test3");
	}
	@Test(groups = {"testng","unit2"})
	public void test4() {
		Log.log("This is Test4");
	}
	@Test(groups = {"unit2"},retryAnalyzer = RetryTest.class)
	public void test5() {
		Log.log("This is Test5");
		AssertJUnit.fail();
	}
	
	

}
