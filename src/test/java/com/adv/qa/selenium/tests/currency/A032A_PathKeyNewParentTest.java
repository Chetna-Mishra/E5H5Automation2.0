package com.adv.qa.selenium.tests.currency;


import java.util.List;

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
 * Test Reference No	: 	A032 Management codes
 * Purpose              :   Set Up Management Codes
 * Date					:   14-05-2014
 * ACCESS               :   ECG
 */

public class A032A_PathKeyNewParentTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("currencyCode");
		
		List<String> pathKeyN1 = dataRow.findNamesReturnValues("pathKeyN1");
		List<String> pathKeyN2 = dataRow.findNamesReturnValues("pathKeyN2");		
		List<String> pathKeyS1 = dataRow.findNamesReturnValues("pathKeyS1");
		List<String> pathKeyE1 = dataRow.findNamesReturnValues("pathKeyE1");
		List<String> pathKeyNBTZ = dataRow.findNamesReturnValues("pathKeyNBTZ");
		List<String> pathKeySBTZ =	dataRow.findNamesReturnValues("pathKeySBTZ");			
		List<String> pathKeyEBTZ = dataRow.findNamesReturnValues("pathKeyEBTZ");
		List<String> pathKeyWBTZ = dataRow.findNamesReturnValues("pathKeyWBTZ");
					
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Path Key List","Currency search page","displayed");
		
	
		/*Edit management code*/
		editManagementCode(currencyPage,pathKeyN1);
		editManagementCode(currencyPage,pathKeyN2);
		editManagementCode(currencyPage,pathKeyS1);
		editManagementCode(currencyPage,pathKeyE1);
		editManagementCode(currencyPage,pathKeyNBTZ);
		editManagementCode(currencyPage,pathKeySBTZ);
		editManagementCode(currencyPage,pathKeyEBTZ);
		editManagementCode(currencyPage,pathKeyWBTZ);
		
		currencyPage.logOut(2);

	}
	

	private void editManagementCode(CurrencyPage currencyPage,List<String> pathkey)
	
	{
		
		currencyPage.searchValuePathKey(companyId,pathkey,6,4);
		
		if(currencyPage.verifyValues(pathkey.get(2)))
		
		{			
			
			currencyPage.clickOnAmend();
			
			currencyPage.createManagementLink(pathkey.get(3));
			
			currencyPage.clickOnUpdate();	
								
			testcases.add(getCurreentDate()+" | Pass : Management code "+pathkey.get(3)+ " updated successfully");
		}
	}
	
	
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "A032A.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
