package com.test.gurukul.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GkBranchPage extends GkBasePage {
	public GkBranchPage(WebDriver driver) {
	super(driver);
	}
	
	private static Logger myLog = Logger.getLogger(GkBranchPage.class);
	
	public String branchPageHeader(){
	String header=null;
	try{
		driver.findElement(objmap.getLocator("branchHeader")).isDisplayed();
		header=driver.findElement(objmap.getLocator("branchHeader")).getText();
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
			}
	return header;
	}

}
