package misc;

import org.testng.annotations.Test;

import util.Configuration;

public class UnitTest {
	
	Configuration config=new Configuration();
	@Test
	public void configurationTest() {
		System.out.println(config.getValue("url"));
	}
	@Test
	public void configNumTest() {
		System.out.println(config.readValueNum("pageLoad"));
	}

}
