package com.test.gurukul.pages;

import com.test.gurukul.utils.ObjectMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.util.Properties;



public abstract class GkBasePage {

	public static final String UIMAP_PROPERTIES = "//src/main/resources/uimap.properties";
	public static WebDriver driver;
	public static String workingDir=System.getProperty("user.dir");
	public static Properties myProps =new Properties();
	public static ObjectMap objmap = new ObjectMap (workingDir+UIMAP_PROPERTIES);


	private static Logger myLog = Logger.getLogger(GkBasePage.class);
	GkLoginPage loginPage=null;

	public GkBasePage(WebDriver driver){
		GkBasePage.driver =driver;
	}

	public boolean verifyLogo() {

		try {
			driver.findElement(objmap.getLocator("gkLogo"));
		} catch (Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		return true;
	}
	
}
