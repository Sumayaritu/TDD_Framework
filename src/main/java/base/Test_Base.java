package base;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.CartPage;
import object.HomePage;
import util.Configuration;

import util.Key;
import static util.I_Browser.*;
import static util.Key.*;

public class Test_Base {
	protected WebDriver driver;
	protected HomePage homepage;
	protected CartPage cartpage;
	Configuration config=new Configuration();

	@BeforeMethod
	public void beforeEachTest() {
		WebDriverManager.chromedriver().setup();
		String browserName=config.getValue(getProp(browser));
		initiatDriver(browserName);
		initiatClasses();
		//driver.manage().window().fullscreen();
		int pageLoadTime=config.readValueNum(getProp(pageLoad));
		int implicitLoadTime=config.readValueNum(getProp(implicitLoad));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitLoadTime));
		String urlName=config.getValue(getProp(url));
		driver.get(urlName);
	}
	public void initiatDriver(String browser) {
		switch (browser) {
		case CHROME :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
	}
	public void initiatClasses() {
		homepage=new HomePage(driver);
		cartpage=new CartPage(driver);
	}
	
	@AfterMethod
	public void closingBrowser() {
		driver.quit();
	}
	public String getProp(Key key) {
		return key.name();
	}
	
}
