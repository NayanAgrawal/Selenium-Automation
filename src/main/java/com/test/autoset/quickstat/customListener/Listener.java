package com.test.autoset.quickstat.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.autoset.quickstat.testBase.TestBase;

public class Listener extends TestBase implements ITestListener {

	/*
	 * WebDriver driver; public Listener(WebDriver driver){ this.driver =
	 * driver; }
	 */

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

		Calendar calander = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM-yyyy_hh_mm_ss");

		String methodName = result.getName();

		if (!result.isSuccess()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {

				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/src/main/java/com/test/autoset/quickstat/";

				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
						+ format.format(calander.getTime()) + ".png");

				FileUtils.copyFile(scrFile, destFile);

				Reporter.log("<a href= '" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
						+ "' height='100' width ='100'/></a>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
