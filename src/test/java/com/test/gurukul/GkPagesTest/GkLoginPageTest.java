package com.test.gurukul.GkPagesTest;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.gurukul.pages.GkAuthenticationPage;
import com.test.gurukul.pages.GkLoginPage;

public class GkLoginPageTest extends Configuration {
	private static Logger myLog = Logger.getLogger(GkLoginPageTest.class);
	GkLoginPage loginPage = null;
	GkAuthenticationPage authenticationPage=null;

	@BeforeMethod
	public void mySetup() {
		loginPage = new GkLoginPage(driver);
		
	}

	@Test
	public void testGkLogo() {
		myLog.info("GkLogo test starting");
		assertTrue(loginPage.verifyLogo());
		myLog.info("===========done logo testing============");
	}
	
	@Test
	public void testGkWelcomeMessage() {
		myLog.info("Gk Welcome Message test starting");
		String welcomeMessage=loginPage.verifyWelcomeMessage();
		Assert.assertEquals(welcomeMessage,"Welcome to Gurukula!");
		myLog.info("===========done logo testing============");
	}
	
	@Test
	public void testLoginLink(){
		myLog.info("Click on Login Link");
		String authenticationHeader =loginPage.gkAuthenticationPage().authenticationHeaderMessage();
		Assert.assertEquals(authenticationHeader, "Authentication");
		myLog.info("===========user landed on Authentication Page============");
	}
	
	@Test
	public void registerNewAccount(){
		myLog.info("Click on New Registration Link");
		String newRegistrationHeader=loginPage.gkNewRegistrationPage().registration();
		Assert.assertEquals(newRegistrationHeader, "Registration");
		
	}
}