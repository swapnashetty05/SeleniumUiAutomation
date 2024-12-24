package TestBase;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class TestBase {

	public ExtentReports rep;
	public ExtentTest test;
	public SoftAssert softAssert;
	public String browser;
	public WebDriver driver;
	public Properties prop=null;

	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext con, ITestResult result) {
		rep = ExtentManager.getReports();
		System.out.println(result.getMethod().getMethodName().toUpperCase());
		test = rep.createTest(result.getMethod().getMethodName().toUpperCase());
		result.setAttribute("reporter", test);
		softAssert = new SoftAssert();
		// init the variable browser
		// browser = con.getCurrentXmlTest().getParameter("browser");
		// System.out.println("browser :" + browser);

		// find the group name from test method parameters
		// System.out.println(con.getAllTestMethods().length);

		String groupNames[] = con.getAllTestMethods()[0].getGroups();
		String browserGroup = "";
		for (String g : groupNames) {
			if (g.startsWith("browsergroup")) {
				browserGroup = g;

				break;
			}
		}

		System.out.println(con.getCurrentXmlTest().getParameter(browserGroup));
		browser = con.getCurrentXmlTest().getParameter(browserGroup);
		System.out.println("Browsergroup is " + browser);

	}

	@AfterMethod
	public void quit() {
		rep.flush();
	}

	public void log(String msg) {
		test.log(Status.INFO, msg);
	}

	public void logFailure(String msg) {// only fails in extent reports
		System.out.println(msg);
		test.log(Status.FAIL, msg);
	}

	public void failAndStopTest(String msg) {// fail in testng as well as extent - but stop
		softAssert(msg);
		// takeScreenShot();
		softAssert.assertAll();// stop the test after asserting
	}

	public void softAssert(String msg) {// fail in testng as well as extent - but continue
		logFailure(msg);// extent
		softAssert.fail(msg); // testng
		// take screenshot as well - put in reports
	}

	public WebDriver launchBrowser(String browserName) {

		if (browserName.equals("Mozilla")) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefox.log");
			FirefoxOptions options = new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			FirefoxProfile prof = new FirefoxProfile();// new profile
			prof.setPreference("dom.webnotifications.enabled", false);
			options.setProfile(prof);
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("Chrome")) {
			// System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
			// "logs\\chrome.log");
			System.setProperty("webdriver.chrome.driver", "//Users//swapnashetty//Desktop//Selenium Code//Drivers//chromedriver-mac-x64//chromedriver");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions ops = new ChromeOptions();
			// ops.setBinary("");
			// ops.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			ops.addArguments("--disable-notifications");
			ops.addArguments("--start-maximized");
			driver = new ChromeDriver(ops);
		} else if (browserName.equals("Edge")) {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			EdgeOptions options = new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			// options.setBinary(new File(""));
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			driver = new EdgeDriver(options);
		}
		// dynamic wait- not pause
		// global time out- all driver.findelement
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// prop file init
		try {

			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + "//src/test//resources//project.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}

	public void takeScreenShot(String filePath) {
		// take screenshot
		// save screenshot in reports screenshot folder
		// add the screenshots in the reports
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(filePath));
			// test.addScreenCaptureFromPath("path of image", "xxxx");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getElementScreenshot(WebElement ele, String filePath) {
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg;
		try {
			fullImg = ImageIO.read(screenshot);
			// Get the location of element on the page
			Point point = ele.getLocation();

			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);

			// Copy the element screenshot to disk
			File screenshotLocation = new File(filePath);
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
