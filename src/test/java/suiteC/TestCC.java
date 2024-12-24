package suiteC;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import TestBase.TestBase;

public class TestCC extends TestBase{

	
	@Test(groups = {"smoke","browsergroup1"})
	public void testCC() throws InterruptedException {
		log("starting CC");
		Thread.sleep(2000);
		log("ending CC");
	}
}
