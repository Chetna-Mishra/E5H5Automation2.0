package com.adv.qa.selenium.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.adv.qa.selenium.helpers.WaitHelper;

public class LoginPage extends Page{

	public LoginPage(EventFiringWebDriver driver) {
		super(driver);
		log.info("In Login Page");
	}

	private PageObjects pObject = new PageObjects();
	
	private WebElement getUserName(){
		return driver.findElement(By.xpath(pObject.LOGIN_USER_NAME));
						}
	
	private WebElement getPassword(){
			return driver.findElement(By.xpath(pObject.LOGIN_PASSWORD));
			}
	

	private WebElement getSignIn(){
		return driver.findElement(By.xpath(pObject.LOGIN_SIGNIN));
	}
	
	public void logIn(String userName,String passWord)
	
	{
		getUserName().sendKeys(userName);
		getPassword().sendKeys(passWord);
		getSignIn().click();
				
		WaitHelper.waitAdditional(4);
		log.info("Successfully logged in");
	}
	
	public boolean isElementPresent(){
		
		WaitHelper.waitUntilWebElementDisplayed(getDriver(), getUserName());
		return getUserName().isDisplayed();
		
	}
	
	public boolean isLoginPageDisplayed(){
		boolean loginPage = false; 
		if(isElementPresent()){
			loginPage = true;
		}
		return loginPage;
	}
}
