package com.test.gurukul.GkPagesTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.gurukul.pages.GkAuthenticationPage;
import com.test.gurukul.pages.GkLoginPage;

public class GkAuthenticationPageTest extends Configuration {
	private static Logger myLog = Logger.getLogger(GkAuthenticationPageTest.class);
	GkLoginPage loginPage = null;
	GkAuthenticationPage authenticationPage=null;
	
	@BeforeMethod
	public void mySetup() {
		loginPage = new GkLoginPage(driver);
		authenticationPage= loginPage.gkAuthenticationPage();
	}
	
	@Test
	public void validUserLogin(){
		myLog.info("===============valid user login started ============");
		String successMessage=authenticationPage.gkHomePage().homePageSuccessMessage();
		Assert.assertEquals(successMessage,"You are logged in as user \"admin\".");
		myLog.info("===============user logged in with valid credentials ============");
	}
	
	@DataProvider(name = "test1")
	   public static Object[][] invalidLoginsTest() {
	      return new Object[][] {{"",""}, {"admin",""}, {"", "admin"}, {"xyz","admin"}, {"admin", "xyz"}};
	   }
	
	@Test(dataProvider = "test1")
	public void invalidCredential(String iUsername, String IPassword){
		myLog.info("===============invalid user login started ============");
		String errorMessage=authenticationPage.invalidLogins(iUsername, IPassword);
		Assert.assertEquals(errorMessage,"Authentication failed!");
		myLog.info("===============invalid user login test done ============");
	}
	
	@Test
	public void registerFromAuthPage(){
		myLog.info("===============New registration from Auth page started ============");
		String newRegistrationHeader=loginPage.gkNewRegistrationPage().registration();
		Assert.assertEquals(newRegistrationHeader, "Registration");
		myLog.info("===============New registration from Auth page done============");
			
		}
	
	@Test
	public void forgotPassword(){
		myLog.info("===============Forgot password link test started ============");
		String forgotPasswordHeader=authenticationPage.forgotPasswordPage().forgotPasswordHeader();
		Assert.assertEquals(forgotPasswordHeader, "Reset your password");
		myLog.info("===============Forgot password link test done============");
		
	}
}
