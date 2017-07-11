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
 * Test Reference No	: 	A001A Switch On online auditing
 * Purpose              :   Switch on online auditing
 * Date					:   15-04-2014
 * Modified by & Date 	: 	Chetna - 03-01-2017
 * ACCESS               :   XDJ
 */

public class A001A_On_line_AuditingTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("code");
		
		List<String> tableValue1 = dataRow.findNamesReturnValues("tableValue1");
		List<String> tableValue2 = dataRow.findNamesReturnValues("tableValue2");
				
		List<String> entityValue1 = dataRow.findNamesReturnValues("entityValue1");
		List<String> entityValue2 = dataRow.findNamesReturnValues("entityValue2");
		
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Table List","Search page","displayed");
		
		/*Search for Table value and verify presence of value in Table*/
		currencyPage.searchEntityValue(tableValue1);
		verifyValues(currencyPage,entityValue1);
		
		/*Select entity value and Edit entity by clicking on Amend*/
		selectEntity(currencyPage,entityValue1);
		
		
		currencyPage.searchEntityValue(tableValue2);
		verifyValues(currencyPage,entityValue2);
		
		/*Select entity value and Edit entity by clicking on Amend*/
		selectEntity(currencyPage,entityValue2);

		/*Logout from the application*/
		currencyPage.logOut(2); 
		
}
	
	private void verifyValues(CurrencyPage currencyPage,List<String> entityValuelist)
	{
						
		/*Verify new currency in the currency list*/
		if(currencyPage.verifyValues(entityValuelist.get(0)))
		
		{
			testcases.add(getCurreentDate()+" | Pass : Currency "+entityValuelist.get(0)+ " displayed in the list");
		}
		else{
			testcases.add(getCurreentDate()+" | Fail : Currency "+entityValuelist.get(0)+ " not displayed in the list");
		}
	}
	

	private void selectEntity(CurrencyPage currencyPage,List<String> entityValuelist) throws InterruptedException
		{
			boolean update = currencyPage.selectEntityValue(entityValuelist);

				if(update == true)
					{
					currencyPage.clickOnAmend();
					
					
					/*Verify Column definition tab displayed by default*/
					if(!currencyPage.isColumnDefinitionTabSelected())
					
					{
						currencyPage.ClickOnAnyTab("Column Definition", 1);
					
					}
					
					Assert.assertTrue(testcases,currencyPage.isColumnDefinitionDispayed(), "Column definition","displayed");
					
						
					verifyColumnDefinitionTab(currencyPage,entityValuelist);
					
					
					/*Navigate to Definition Defn tab*/
					currencyPage.clickOnDefinitionDef();
					
					/*Verift Definition Def page/section displayed*/
					Assert.assertTrue(testcases,currencyPage.isDefinitionDefnDispayed(), "Column definition def","displayed");
					
					verifyDefinitionDefTab(currencyPage,entityValuelist);
					
			
					}
		
		}
	
	private void verifyColumnDefinitionTab(CurrencyPage currencyPage,List<String> entityValuelist) throws InterruptedException
	{
		currencyPage.verifyColumnDefinitionTab(entityValuelist);
	}	
	
	
	private void verifyDefinitionDefTab(CurrencyPage currencyPage,List<String> entityValuelist) throws InterruptedException
	{
		currencyPage.verifyDefinitionDefTab(entityValuelist);
		
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
		String[] nodeID = { "A001A" };
		String [] selectedNames = {"userName","passWord","code","tableValue1","tableValue2","entityValue1","entityValue2"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
