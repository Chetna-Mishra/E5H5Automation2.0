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
 * Test Reference No	: 	A005 Currency Exchange Rates
 * Purpose              :   Set Up Currency Exchange Rates.
 * Date					:   24-04-2014
 * ACCESS               :   AGI
 */

public class A005_Currency_Exchange_RatesTest extends BaseTest

{
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
		String value = dataRow.get("value");
		List<String> gbpusdCurrency = dataRow.findNamesReturnValues("gbpusdCurrency");
		List<String> gbpfrfCurrency = dataRow.findNamesReturnValues("gbpfrfCurrency");
		List<String> gbpdemCurrency = dataRow.findNamesReturnValues("gbpdemCurrency");
		List<String> gbpeurCurrency = dataRow.findNamesReturnValues("gbpeurCurrency");
		List<String> eurgbpCurrency = dataRow.findNamesReturnValues("eurgbpCurrency");
				
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Exchange Rate List","Currency search page","displayed");
		
		currencyPage.searchValue(value,5,0);
		
		currencyPage.clickOnInsert();
		
		/*Create currency exchange rate*/
		createCurrencyExchange(currencyPage,gbpusdCurrency);
		createCurrencyExchange(currencyPage,gbpfrfCurrency);
		createCurrencyExchange(currencyPage,gbpdemCurrency);
		createCurrencyExchange(currencyPage,gbpeurCurrency);
		createCurrencyExchange(currencyPage,eurgbpCurrency);
		
		/*Exit from the currency exchange edit page*/
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		/*Already included successful msg in the creation part hence commenting*/
//		verifyValues(currencyPage,gbpusdCurrency);
//		verifyValues(currencyPage,gbpfrfCurrency);
//		verifyValues(currencyPage,gbpdemCurrency);
//		verifyValues(currencyPage,gbpeurCurrency);
//		verifyValues(currencyPage,eurgbpCurrency);
		
		currencyPage.logOut(2);
	}
	
	
	private void createCurrencyExchange(CurrencyPage currencyPage,List<String> currencyList) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed"; 
		
		/*Create currency exchange rate*/
		boolean update = currencyPage.enterCurrencyExchangeRateDetails(currencyList);

		if(update == true){			
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "Exchange Rate Type "+currencyList.get(1), "created successfully");
			
		}
		
		else{
			testcases.add(getCurreentDate()+" | Pass : Exchange Rate Type "+currencyList.get(1)+ " already created");
		}
	}	
	
	
	
	
	
//	private void createCurrencyExchange(CurrencyPage currencyPage,List<String> currencyList) throws InterruptedException{
//		
//		String message = "The previously-requested action has been performed"; 
//		
//		/*Create currency exchange rate*/
//		boolean update = currencyPage.enterCurrencyExchangeRateDetails(currencyList);
//
//		if(update == true){			
//			currencyPage.clickOnUpdate();
//			
//			if(currencyPage.getErrorContentText().contains(message))
//			
//			
//			{
//				testcases.add(getCurreentDate()+" | Pass : Exchange Rate Type "+currencyList.get(1)+ " created");
//			}
//			else{
//				testcases.add(getCurreentDate()+" | Fail : Exchange Rate Type "+currencyList.get(1)+ " not created");
//			}
//		
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Pass : Exchange Rate Type "+currencyList.get(1)+ " already created");
//		}
//	}
	
//	private void verifyValues(CurrencyPage currencyPage,List<String> currencyList){
//		/*Search currency*/
//		currencyPage.searchValue(currencyList,5,2);
//		
//		/*Verify new currency in the list*/
//		if(currencyPage.verifyValues(currencyList.get(1))){
//			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(1)+ " displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : Currency "+currencyList.get(1)+ " not displayed in the list");
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
		String[] nodeID = { "A005" };
		String [] selectedNames = {"userName","passWord","code","value","gbpusdCurrency","gbpfrfCurrency","gbpdemCurrency", "gbpeurCurrency","eurgbpCurrency"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
