package suiteA;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestBase.TestBase;
import dataProvider.TestDataProvider;
import reports.ExtentManager;

public class TestA extends TestBase{

	

	@Test(groups = {"sanity","browsergroup1"},dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteA")
	public void testA(String username, String password) throws InterruptedException {
		
		log("Starting A");
		//10
		if(!"Title1".equals("Title"))
			softAssert("Titles do not match.");
		
		//10
		log("Logging into application");
		log("Booking ticket");
		
		if(!"Text1".equals("Text"))
		    softAssert("Text not matches");
		
		
		if(!"a".equals("b"))
			failAndStopTest("a is not valid");
		
		//Assert.fail("Some error message");// listener called , stop the test
		
		log(username+" -- "+password);
		Thread.sleep(2000);
		log("Ending A");
		softAssert.assertAll();
		
		// errors will go in the end
		// using hard assert - soft assert errors are not reported
		
	}
}
