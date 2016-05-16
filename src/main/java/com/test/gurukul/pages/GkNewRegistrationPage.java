package com.test.gurukul.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GkNewRegistrationPage extends GkBasePage {
	
	public GkNewRegistrationPage(WebDriver driver) {
		super(driver);
		}
	private static Logger myLog = Logger.getLogger(GkLoginPage.class);
	
	public String registration(){
		String header=null;
		try{
			driver.findElement(objmap.getLocator("registrationHeader")).isDisplayed();
			header=driver.findElement(objmap.getLocator("registrationHeader")).getText();
			}catch(Exception e) {
				myLog.error(e.getMessage());
				Assert.fail(e.getMessage());
				}
		return header;
		}

}
