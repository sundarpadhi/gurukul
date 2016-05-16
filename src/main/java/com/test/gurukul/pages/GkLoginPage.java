package com.test.gurukul.pages;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



// GK HomePage Methods
public class GkLoginPage extends GkBasePage {
	
	public GkLoginPage(WebDriver driver) {
		super(driver);
		}

	private static Logger myLog = Logger.getLogger(GkLoginPage.class);
	
	public String verifyWelcomeMessage() {
		String message =null;
		try {
			message=driver.findElement(objmap.getLocator("welcomeMessage")).getText();
		} catch (Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		return message;
	}
	
	public GkAuthenticationPage gkAuthenticationPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		try{
			driver.findElement(objmap.getLocator("loginLink")).isDisplayed();
			driver.findElement(objmap.getLocator("loginLink")).click();
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		return new GkAuthenticationPage(driver);
	}
	
	public GkNewRegistrationPage gkNewRegistrationPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		try{
			driver.findElement(objmap.getLocator("newRegLink")).isDisplayed();
			driver.findElement(objmap.getLocator("newRegLink")).click();
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		return new GkNewRegistrationPage(driver);
	}


}