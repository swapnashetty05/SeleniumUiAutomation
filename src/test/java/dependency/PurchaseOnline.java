package dependency;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseOnline {
	
	
	@Test
	public void searchProd() {
		AssertJUnit.fail();
	}
	
	
	@Test(dependsOnMethods = {"searchProd"})
	public void buyProd() {
		
	}
	
	@Test(dependsOnMethods = {"buyProd"})
	public void confirmEmail() {
		
	}

}
