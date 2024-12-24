package suiteA;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import TestBase.TestBase;
import dataProvider.TestDataProvider;

public class TestAA extends TestBase{
	
	@Test(groups = {"smoke","browsergroup2"},dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteA")
	public void testAA(String userName, String password) throws InterruptedException {
		System.out.println("Starting AA ");
		log(userName+" -- "+password);
		System.out.println("Starting AA x");
		Thread.sleep(2000);
		System.out.println("Ending AA");
	}
	
	

}
