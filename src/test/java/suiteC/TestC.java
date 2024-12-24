package suiteC;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import TestBase.TestBase;

public class TestC extends TestBase{
	
	//@Parameters("browser")
	@Test(groups = {"smoke","browsergroup1"})
	public void testC() throws InterruptedException {
		log("starting C   "+browser);
		//System.out.println("starting C   "+browser);
		Thread.sleep(2000);
		log("ending C");
	}

}
