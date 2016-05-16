package com.test.gurukul.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GkForgotPasswordPage extends GkBasePage {
	public GkForgotPasswordPage(WebDriver driver) {
	super(driver);
	}
	
	private static Logger myLog = Logger.getLogger(GkForgotPasswordPage.class);
	
	public String forgotPasswordHeader(){
	String header=null;
	try{
		driver.findElement(objmap.getLocator("headerForgotPassword")).isDisplayed();
		header=driver.findElement(objmap.getLocator("headerForgotPassword")).getText();
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
			}
	return header;
	}

}
