package com.test.gurukul.GkPagesTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.gurukul.pages.GkAuthenticationPage;
import com.test.gurukul.pages.GkLandingHomePage;
import com.test.gurukul.pages.GkLoginPage;

public class GkLandingHomePageTest extends Configuration {
	private static Logger myLog = Logger.getLogger(GkLandingHomePageTest.class);
	GkLoginPage loginPage = null;
	GkAuthenticationPage authenticationPage=null;
	GkLandingHomePage landingHomePage=null;
	
	@BeforeMethod
	public void mySetup() {
		loginPage = new GkLoginPage(driver);
		landingHomePage= loginPage.gkAuthenticationPage().gkHomePage();
	}
	
	@Test
	public void branchEntityCheck(){
		myLog.info("=================Checking Branch Entity Started===============");
		String branchHeader=landingHomePage.branchPage().branchPageHeader();
		Assert.assertEquals(branchHeader,"Branches");
		myLog.info("===========done logo testing============");
	}

}
