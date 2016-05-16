package com.test.gurukul.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GkAuthenticationPage extends GkBasePage {
		
	public GkAuthenticationPage(WebDriver driver) {
		super(driver);
		}
	private static Logger myLog = Logger.getLogger(GkAuthenticationPage.class);
		
	public String authenticationHeaderMessage(){
		String header=null;
		try{
			driver.findElement(objmap.getLocator("pageHeader")).isDisplayed();
			header=driver.findElement(objmap.getLocator("pageHeader")).getText();
			}catch(Exception e) {
				myLog.error(e.getMessage());
				Assert.fail(e.getMessage());
				}
		return header;
		}
	
	public GkLandingHomePage gkHomePage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			driver.findElement(objmap.getLocator("usernameTextBox")).isDisplayed();
		    driver.findElement(objmap.getLocator("usernameTextBox")).sendKeys("admin");
		    driver.findElement(objmap.getLocator("passwordTextBox")).isDisplayed();
		    driver.findElement(objmap.getLocator("passwordTextBox")).sendKeys("admin");
		    driver.findElement(objmap.getLocator("authenticateButton")).click();
		
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
			}
		return new GkLandingHomePage(driver);
	}
	
	public String invalidLogins(String username, String password){
		String errorMessage=null;
		try{
			driver.findElement(objmap.getLocator("usernameTextBox")).isDisplayed();
		    driver.findElement(objmap.getLocator("usernameTextBox")).sendKeys(username);
		    driver.findElement(objmap.getLocator("passwordTextBox")).isDisplayed();
		    driver.findElement(objmap.getLocator("passwordTextBox")).sendKeys(password);
		    driver.findElement(objmap.getLocator("authenticateButton")).click();	
		    errorMessage=driver.findElement(objmap.getLocator("authError")).getText();
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
			}
		return errorMessage;
	}
	
	public GkForgotPasswordPage forgotPasswordPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			driver.findElement(objmap.getLocator("forgotPasswordLink")).isDisplayed();
		    driver.findElement(objmap.getLocator("forgotPasswordLink")).click();
		
		}catch(Exception e) {
			myLog.error(e.getMessage());
			Assert.fail(e.getMessage());
			}
		return new GkForgotPasswordPage(driver);
	}
}