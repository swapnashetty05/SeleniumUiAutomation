package suiteB;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestBB extends TestBase{

	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteB")
	public void testBB(String userName, String password) throws InterruptedException {
		log("starting BB");
		log(userName + "  " + password);
		Thread.sleep(2000);
		log("ending BB");
	}
}
