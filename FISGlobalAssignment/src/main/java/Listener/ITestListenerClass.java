package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenerClass  extends ExtentReportListener implements ITestListener{
	
	private static ExtentReports extent;
	
	
	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		System.out.println("===========Execution started================");
		try {
			extent = setUp();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		System.out.println("=============Execution completed ==============");
		extent.flush();
		System.out.println("Generated Report..");
	}

}
