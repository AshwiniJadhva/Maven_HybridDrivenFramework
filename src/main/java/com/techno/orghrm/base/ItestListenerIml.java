package com.techno.orghrm.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenerIml extends PredefinedActions implements ITestListener {

	public void onTestStart(ITestResult result) {
		start();
	}

	public void onTestSuccess(ITestResult result) {
		tearDown();
	}

	public void onTestFailure(ITestResult result) {
		tearDown();
	}

	public void onTestSkipped(ITestResult result) {
		tearDown();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
