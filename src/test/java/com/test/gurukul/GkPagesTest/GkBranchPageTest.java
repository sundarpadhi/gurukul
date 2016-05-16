package com.test.gurukul.GkPagesTest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.gurukul.pages.GkAuthenticationPage;
import com.test.gurukul.pages.GkBranchPage;
import com.test.gurukul.pages.GkLandingHomePage;
import com.test.gurukul.pages.GkLoginPage;

public class GkBranchPageTest extends Configuration {
	private static Logger myLog = Logger.getLogger(GkBranchPageTest.class);
	GkLoginPage loginPage = null;
	GkAuthenticationPage authenticationPage=null;
	GkLandingHomePage landingHomePage=null;
	GkBranchPage branchPage=null;
	
	@BeforeMethod
	public void mySetup() {
		loginPage = new GkLoginPage(driver);
		branchPage= loginPage.gkAuthenticationPage().gkHomePage().branchPage();
	}
	
	@DataProvider(name = "test1")
	   public static Object[][] invalidLoginsTest() {
	      return new Object[][] {{"Sahid Nagar",001}, {"admin",""}, {"", "admin"}, {"xyz","admin"}, {"admin", "xyz"}};
	   }
	
	
	@Test
	public void createNewBranch(){
		
		
		
	}

}
