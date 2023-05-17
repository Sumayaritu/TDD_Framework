package misc;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinearScripting {
	WebDriver driver;

	@BeforeMethod
	public void beforeEachTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
       public void test_OrderNow_Button() {
		driver.get("https://www.walgreens.com/findcare/covid19/otc?ban=ct23_OTC_hero");
		WebElement element = driver.findElement(By.xpath("//a[@class=\"logo-contain\"]"));
		String logo = element.getAttribute("logo");// TODO
		System.out.println(logo);
	}

	@Test
	public void test_WeeklyAdd_Button() {
		driver.get("https://www.walgreens.com/");
		WebElement element = driver.findElement(By.xpath("//li[@id=\"Default_Left_Slot_New_a_CB-2\"]"));
		String title = element.getAttribute("innerHTML");
		System.out.println(title);
}
	@Test
	public void testWalgreensHomePage() {
		driver.get("https://www.walgreens.com/");
		WebElement element=driver.findElement(By.xpath("//a[@class='logo-contain']/span/img"));
		String alt=element.getAttribute("alt");
		System.out.println(alt);
	}
	@AfterMethod
public void closingDriver() {
		driver.quit();
	}

}
