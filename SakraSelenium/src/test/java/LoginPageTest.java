import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
	WebDriver driver = null;

	@Test(dataProvider = "testData")
	public void doLogin(String username, String password, String browser) {
		

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.findElement(By.name("proceed")).click();
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.alertIsPresent());
			
			//alert
			
			Alert a1 = driver.switchTo().alert();
			a1.accept();
			
			
		}else if (browser.equals("mozilla")) {
			System.out.println("lets try this later");
		}

	}

	@DataProvider
	public Object[][] testData() {
		return new Object[][] { new Object[] { "swap", "abc", "chrome" }, new Object[] { "pk", "bkkl", "mozilla" }, };
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
