package com.test.gurukul.config;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestConfigurations {

	private static final String IE_DRIVER_SERVER = "bin//IEDriverServer.exe";
	private static final String WINDOWS_CHROMEDRIVER = "bin//chromedriver.exe";
	private static final String MAC_CHROMEDRIVER = "bin//chromedriver";
	public static String workingDir=System.getProperty("user.dir");


	public static WebDriver getDriver() throws Exception{
		WebDriver driver= null;
		String browser ;
		String remoteExe;
		
		Properties myProps =new Properties();
		myProps.load(new FileReader(new File(workingDir+"//src//main//resources//env.properties")));
		String overrideBrowser = System.getProperty("browser");
		String Execution = System.getProperty("remote");

		if (!StringUtils.isBlank(overrideBrowser)){
			browser = System.getProperty("browser").toLowerCase();
		}
		else {
			browser = myProps.getProperty("driver").toLowerCase();
		}

		if (!StringUtils.isBlank(Execution)){
			remoteExe = System.getProperty("remote");
		}
		else {
			remoteExe = myProps.getProperty("remote");
		}

		if (browser.equals("firefox")){
			DesiredCapabilities capability = DesiredCapabilities.firefox();

			if(remoteExe.equals("false")){

				driver = new FirefoxDriver(capability);
			}
			else {

				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			}
		}
		else if(browser.equals("ie")){

			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver",IE_DRIVER_SERVER);

			if(remoteExe.equals("false")){
				driver =new InternetExplorerDriver(capability);
			}
			else {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			}
		}

		else if (browser.equals("safari")){

			DesiredCapabilities capability = DesiredCapabilities.safari();

			if(remoteExe.equals("false")){
				driver = new SafariDriver(capability);
			}
			else {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			}
		}
		else if(browser.equals("chrome")){

			DesiredCapabilities capability = DesiredCapabilities.chrome();
			String oS = System.getProperty("os.name").toLowerCase();

			if (oS.contains("mac")){
				System.setProperty("webdriver.chrome.driver",MAC_CHROMEDRIVER);
			}
			else {
				System.setProperty("webdriver.chrome.driver",WINDOWS_CHROMEDRIVER);
			} 
			if(remoteExe.equals("false")){
				driver = new ChromeDriver(capability);
			}
			else {

				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			}
		}

		myProps=null;
		return driver;
	}

} 
