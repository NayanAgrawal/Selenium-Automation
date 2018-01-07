package com.test.autoset.quickstat.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.test.autoset.quickstat.excelReader.Excel_Reader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	Excel_Reader excel;

	// String url = "http://demo.automationtesting.in/Register.html";
	String url = "http://automationpractice.com/index.php";
	String browser = "chrome";

	public void init() {

		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			log.info("Creating object of " + browser);
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}

	public void getUrl(String url) {
		log.info("Navigating to : " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public String[][] getData(String excelName, String sheetName) throws Exception {
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/autoset/quickstat/data/" + excelName;
		excel = new Excel_Reader(path);
		int rows = excel.getRowCount(sheetName);
		int column = excel.getCouumnCount(sheetName);
		String[][] excelData = null;
		excelData = new String[rows - 1][column];

		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < column; j++) {
				excelData[i - 1][j] = excel.getCellData(sheetName, j, i);
			}
		}
		return excelData;
	}

	public void getScreenshot(String name) {

		Calendar calander = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM-yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/test/autoset/quickstat/screenshot/";

			File destFile = new File(
					(String) reportDirectory + name + "_" + format.format(calander.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href= '" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width ='100'/></a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
