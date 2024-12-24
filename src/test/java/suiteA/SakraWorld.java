package suiteA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import TestBase.TestBase;

public class SakraWorld extends TestBase {

	@Test
	public void appointmentTest() {
		launchBrowser("Chrome"); // prop init
		log("Opened browser Chrome");
		System.out.println("URL is : " +prop.getProperty("url"));
		driver.get(prop.getProperty("url")); // 100%
		// driver.findElement(By.cssSelector("xxxxx"));
	//	waitForPageToLoad();

	//	driver.findElement(By.linkText(prop.getProperty("doctor_name"))).click();
		// validate the presence and visibility
		// *********************************Explicit
		// wait*********************************

	}

	/*
	 * public void waitForPageToLoad() { JavascriptExecutor js =
	 * (JavascriptExecutor) driver; int i = 0;
	 * 
	 * while (i != 10) { String state = (String)
	 * js.executeScript("return document.readyState;"); System.out.println(state);
	 * 
	 * if (state.equals("complete")) break; else wait(2);
	 * 
	 * i++; } // check for jquery status i = 0; while (i != 10) {
	 * 
	 * Long d = (Long) js.executeScript("return jQuery.active;");
	 * System.out.println(d); if (d.longValue() == 0) break; else wait(2); i++;
	 * 
	 * }
	 * 
	 * }
	 */
}
