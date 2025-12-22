package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationCore.Base;
import utilities.ExtentReportUtility;

public class Listeners extends Base implements ITestListener {//predefined interface
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();//configure extentReportUtility 
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
 
	public void onTestStart(ITestResult result) {//executed before each test execution

		ITestListener.super.onTestStart(result);//fetch the method name and attached to the report with the hlp of get method name
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {//invoke when a testcases being passed

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {//invoke when a testcases being failed

		ITestListener.super.onTestFailure(result);

		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) {//automtically invoke when a test case is skipped

		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {//when a test fails but is still within the allowed success percentage

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {//when a test fails because it exceeded the time limit

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {// This method is executed before any test methods start running

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {//executed after all test methods have finished execution

		ITestListener.super.onFinish(context);
		extent.flush();// report not generate properly
	}
}
