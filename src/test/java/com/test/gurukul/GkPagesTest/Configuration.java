package com.test.gurukul.GkPagesTest;

import com.test.gurukul.config.TestConfigurations;
import com.test.gurukul.utils.ObjectMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public abstract class Configuration {

	public String workingDir=System.getProperty("user.dir");
	public ObjectMap objmap = new ObjectMap (workingDir+"//src/main/resources/uimap.properties");
	public static final Logger Log = Logger.getLogger(Configuration.class);
	public static String adminUserName;
	public static  String adminPasswd;
	public String env;
	public String baseUrl;
	public WebDriver driver;

	private static Logger myLog = Logger.getLogger(GkLoginPageTest.class);

	@BeforeMethod
	public void setUp(){
		Properties myProps =new Properties();
		try {
			driver=TestConfigurations.getDriver();

			myProps.load(new FileReader(new File(workingDir+"//src//main//resources//env.properties")));

		} catch (Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		adminUserName= myProps.getProperty("adminUserName");
		adminPasswd= myProps.getProperty("adminPasswd");
		baseUrl=myProps.getProperty("baseurl");


		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) {

		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String testName = testResult.getName();
			DateFormat dateFormat = new SimpleDateFormat("dd_MM_yy__hh_mm_ssaa");
			Date date = new Date();
			String workingDir=System.getProperty("user.dir");

			try {
				FileUtils.copyFile(scrFile, new File(workingDir +"//screenshots//"+ testName + dateFormat.format(date) +".jpg"));
			} catch (IOException e) {
				myLog.error(e.getMessage());
			}
			driver.quit();
		}  
		else {
			driver.quit();
		}

	}


	@AfterClass
	public void myTearDown(){
		driver.quit();
		Log.info("@AfterClass test done");

	}

	@AfterSuite
	public void tearDown(){
		Log.info("Test Execution completed at" +  System.currentTimeMillis() );
		driver.quit();
	}

}
