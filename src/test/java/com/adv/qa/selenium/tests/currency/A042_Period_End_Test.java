package com.adv.qa.selenium.tests.currency;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPage;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A042 Period End
 * Purpose              :   Run Period End
 * Date					:   26-05-2014
 * ACCESS               :   EYB
 */

public class A042_Period_End_Test extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp", groups="a")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("code");
		String errorMessage = dataRow.get("errorMessage");
		String errorMessage1 = dataRow.get("errorMessage1");
		int period = 0;
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Period and Year End List","Structure Rebuild page","displayed");

		currencyPage.searchPeriodAndYearDetails(companyId);
		
		period = Integer.parseInt(currencyPage.periodOfTheYear());
		
//		if(period<=12){
		if(period<12){
			do{
				currencyPage.clickOnCloseGLPeriod();
				currencyPage.clickOnUpdate();
				
				period = Integer.parseInt(currencyPage.periodOfTheYear());
			}while(period != 12);
		}

		if(period==12){
			currencyPage.clickOnCloseGLPeriod();
		}
		
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(errorMessage1), "Error message "+errorMessage,"displayed.");
		
		currencyPage.logOut(2);

	}

	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A042" };
		String [] selectedNames = {"userName","passWord","code","errorMessage"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}

