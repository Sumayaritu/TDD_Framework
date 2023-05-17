package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.CreatAccountPage;
import object.HomePage;
import object.SignInPage;
import report.ExtentReport;
import util.Configuration;

import util.Key;
import static util.I_Browser.*;
import static util.Key.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.time.Duration;

public class Test_Base extends ExtentReportListener {
	protected WebDriver driver;
	protected HomePage homepage;
	protected SignInPage signInPage;
	protected CreatAccountPage creatAccountPage;
	Configuration config = new Configuration();

	@Parameters("browser")
	@BeforeMethod
	public void beforeEachTest(@Optional("Opera") String browserName) {
		WebDriverManager.chromedriver().setup();
		// String browserName=config.getValue(getProp(browser));
		initiatDriver(browserName);
		initiatClasses();
		// driver.manage().window().fullscreen();
		int pageLoadTime = config.readValueNum(getProp(pageLoad));
		int implicitLoadTime = config.readValueNum(getProp(implicitLoad));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitLoadTime));
		String urlName = config.getValue(getProp(url));
		driver.get(urlName);
	}

	public void initiatDriver(String browser) {
		switch (browser) {
		case CHROME:
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
		homepage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		creatAccountPage = new CreatAccountPage(driver);
	}

	private String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	@AfterMethod
	public void aftereEachTest(ITestResult result, Method method) {
		for (String group : result.getMethod().getGroups()) {
			ExtentReport.getTest().assignCategory(group);
		}

		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentReport.getTest().log(Status.INFO, "Test Passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentReport.getTest().log(Status.FAIL, "Test Failed");
			ExtentReport.getTest().log(Status.FAIL, getStackTrace(result.getThrowable()));
			ExtentReport.getTest().addScreenCaptureFromPath(captureScreenShot(method, driver));
		}
	}

	@AfterMethod
	public void closingBrowser() {
		driver.quit();
	}

	public String getProp(Key key) {
		return key.name();
	}

}
