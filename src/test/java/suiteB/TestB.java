package suiteB;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestB extends TestBase{
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteB")
	public void testB(String userName, String password) throws InterruptedException {
		log("starting B");
		log(userName + "  " + password);
		Thread.sleep(2000);
		log("ending B");
	}

}
