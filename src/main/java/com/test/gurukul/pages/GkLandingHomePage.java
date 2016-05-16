package com.test.gurukul.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GkLandingHomePage extends GkBasePage {
	public GkLandingHomePage(WebDriver driver) {
	super(driver);
	}
	
	private static Logger myLog = Logger.getLogger(GkLandingHomePage.class);
	
	
	public String homePageSuccessMessage(){
	String header=null;
	try{
		driver.findElement(objmap.getLocator("successMessage")).isDisplayed();
		header=driver.findElement(objmap.getLocator("successMessage")).getText();
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
			}
	return header;
	}
	
	public GkBranchPage branchPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		try{
			driver.findElement(objmap.getLocator("entitiesDropdown")).isDisplayed();
			driver.findElement(objmap.getLocator("entitiesDropdown")).click();
			driver.findElement(objmap.getLocator("brachLink")).click();
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		return new GkBranchPage(driver);
	}
}
