package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomListener implements ITestListener {

	
	public void onTestFailure(ITestResult result) {
		System.out.println("----Test fail");
		ExtentTest test = (ExtentTest)result.getAttribute("reporter");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("----Test Passed----");
		ExtentTest test = (ExtentTest)result.getAttribute("reporter");
		test.log(Status.PASS, "Test passed : "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("----Test skipped----");
		ExtentTest test = (ExtentTest)result.getAttribute("reporter");
		test.log(Status.SKIP, "Test skipped : "+result.getName());
	}
}
