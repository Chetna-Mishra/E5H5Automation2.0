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
 * Test Reference No	: 	A002 Currency Descriptions
 * Purpose              :   Set Up Currency Descriptions
 * Date					:   15-04-2014
 * ACCESS               :   AGA
 */

/**
 * Modified By          :   Chetna Mishra
 * Modified Date		:   17-01-2016
 * Code					: 	AGA
 */

public class A002_Currency_DescriptionTest extends BaseTest{
	
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
				
		List<String> eurCurrency = dataRow.findNamesReturnValues("eurCurrency");
		List<String> demCurrency = dataRow.findNamesReturnValues("demCurrency");
		List<String> usdCurrency = dataRow.findNamesReturnValues("usdCurrency");
		List<String> frfCurrency = dataRow.findNamesReturnValues("frfCurrency");

		
		
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Currency List","Search page","displayed");
		
		/*Insert new currency*/
		currencyPage.clickOnInsert();
		
		/*Create currency*/
		createCurrency(currencyPage,eurCurrency);
		createCurrency(currencyPage,demCurrency);
		createCurrency(currencyPage,usdCurrency);
		createCurrency(currencyPage,frfCurrency);

		
		/*Exit from the currency page*/
		currencyPage.clickOnCancel();
		
		/*Already included successful msg in the creation part hence commenting*/
		
//		/*Search and Verify Currenecy in the list*/
//		verifyValues(currencyPage,eurCurrency);
//		verifyValues(currencyPage,demCurrency);
//		verifyValues(currencyPage,usdCurrency);
//		verifyValues(currencyPage,frfCurrency);
		
		
		/*Logout from the application*/
		currencyPage.logOut(2);	
	}
	
	

	private void createCurrency(CurrencyPage currencyPage,List<String> currencyList) throws InterruptedException
	{
		String SuccMessage = "The previously-requested action has been performed";
		
		boolean update = currencyPage.addNewCurrency(currencyList);
		
		if(update == true) {
			currencyPage.clickOnUpdate();
 			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "Currency "+currencyList.get(0), "created successfully");
		}
			
		else{
			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(0)+ " already Created and displayed in the list");
		}
	}
	
	
	
	
//	
//	private void createCurrency(CurrencyPage currencyPage,List<String> currencyList) throws InterruptedException
//	{
//		String message = "The previously-requested action has been performed";
//		
//		boolean update = currencyPage.addNewCurrency(currencyList);
//		
//		if(update == true) {
//			currencyPage.clickOnUpdate();
//			
////			if(currencyPage.getToolContentText().contains(message))
//			if(currencyPage.getErrorContentText().contains(message))
//				
//			{
//				
//	
//				testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(0)+ " Created and displayed in the list");
//				
//			}
//			else{
//				testcases.add(getCurreentDate()+" | Fail : Currency "+currencyList.get(0)+ " not Created and displayed in the list");
//			}
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(0)+ " already Created and displayed in the list");
//		}
//	}
			
	
	
//	private void verifyValues(CurrencyPage currencyPage,List<String> currencyList)
//	{
//		currencyPage.searchValue(currencyList, 1, 0);
//				
//		/*Verify new currency in the currency list*/
//		if(currencyPage.verifyValues(currencyList.get(0)))
//		
//		{
//			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(0)+ " searched and displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : Currency "+currencyList.get(0)+ " not searched and displayed in the list");
//		}
//	}


	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A002" };
		String [] selectedNames = {"userName","passWord","code","eurCurrency","demCurrency","usdCurrency","frfCurrency"};
				
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
