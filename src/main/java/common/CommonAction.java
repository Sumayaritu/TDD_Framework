package common;

import org.openqa.selenium.WebElement;

import report.Log;

public class CommonAction {
	public static String getInnerHTML(WebElement element) {
		String innerText=element.getAttribute("innerHTML");
		Log.log(element+"<<<<<innerText>>>>>:"+innerText);
		return innerText;
	}
	public static void click(WebElement element) {
		element.click();
		Log.log(element+"<<<<<<<Has been clicked>>>>>>>>");
	}
	
	public static void insert(WebElement element,String msg) {
		element.sendKeys(msg);
		Log.log(element+"<<<<<value inserted:"+msg);
	}

}
