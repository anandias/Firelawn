package com.Ecommerce.Firelawn.genericLib;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//import from java.sql.connection
	public static java.sql.Connection con;
	public FileUtilities fu= new FileUtilities();
	public WebDriver driver;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	
	//we have to write@BeforeSuite with one non static method
	//add testng library then we have to import @BeforeSuite
	@BeforeSuite
	public void configDataBase() throws SQLException {
		Reporter.log("Connect to database");
		//we have to run @beforesuite and @aftersuite only once
		//we will connect and close the data base only once
		con=fu.getDataDB();
		htmlreport=new ExtentHtmlReporter(Autoconatant.reportsPath);
		htmlreport.config().setDocumentTitle("FireLawnReport");
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		
	}
	
	@BeforeMethod
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get(" ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException {
		int result = res.getStatus();
		if(result==ITestResult.FAILURE) {
			test.log(Status.FAIL, res.getName()+"Testcase is failed");
			test.log(Status.FAIL, res.getThrowable()+"Testcase failed exception is");
		}
		else if(result==ITestResult.SUCCESS) {
			test.log(Status.PASS, res.getName()+"Testcase is passed");
		}
		else if(result==ITestResult.SKIP) {
			test.log(Status.SKIP, res.getName()+"Testcase is skipped");
		}
		String name=res.getName();
		if(result==2) {
			Screenshot s = new Screenshot();
			s.getPhoto(driver, name)
			;
		}
		
		driver.quit();
	}
	@AfterSuite
	public void configAs() throws SQLException {
		reports.flush();
		fu.closeDB();
		Reporter.log("Database is closed");
	}
	

}
