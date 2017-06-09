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
 * Test Reference No	: 	A004 Currency Exchange Rate Types
 * Purpose              :   Set Up Currency Exchange Rate Types
 * Date					:   24-04-2014
 * ACCESS               :   AGG
 */

public class A004_Currency_Exchange_Rate_TypesTest extends BaseTest{
		
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
		List<String> gbpusdCurrency = dataRow.findNamesReturnValues("gbpusdCurrency");
		List<String> gbpfrfCurrency = dataRow.findNamesReturnValues("gbpfrfCurrency");
		List<String> gbpdemCurrency = dataRow.findNamesReturnValues("gbpdemCurrency");
		List<String> gbpeurCurrency = dataRow.findNamesReturnValues("gbpeurCurrency");
		List<String> eurgbpCurrency = dataRow.findNamesReturnValues("eurgbpCurrency");
		List<String> demgbpCurrency = dataRow.findNamesReturnValues("demgbpCurrency");
		List<String> frfgbpCurrency = dataRow.findNamesReturnValues("frfgbpCurrency");
				
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
//		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Exchange Rate Type List","Currency search page","displayed");
		
		currencyPage.clickOnInsert();
		
		/*Create currency exchange rate*/
		createCurrencyExchangeRate(currencyPage,gbpusdCurrency);
		createCurrencyExchangeRate(currencyPage,gbpfrfCurrency);
		createCurrencyExchangeRate(currencyPage,gbpdemCurrency);
		createCurrencyExchangeRate(currencyPage,gbpeurCurrency);
		createCurrencyExchangeRate(currencyPage,eurgbpCurrency);
		createCurrencyExchangeRate(currencyPage,demgbpCurrency);
		createCurrencyExchangeRate(currencyPage,frfgbpCurrency);
				
		/*Exit from the currency exchange details page*/
		currencyPage.clickOnCancel();
		
		verifyValues(currencyPage,gbpusdCurrency);
		verifyValues(currencyPage,gbpfrfCurrency);
		verifyValues(currencyPage,gbpdemCurrency);
		verifyValues(currencyPage,gbpeurCurrency);
		verifyValues(currencyPage,eurgbpCurrency);
		verifyValues(currencyPage,demgbpCurrency);
		verifyValues(currencyPage,frfgbpCurrency);

		/*Logout from the application*/
		currencyPage.logOut(2);
	
	}
	
	private void createCurrencyExchangeRate(CurrencyPage currencyPage,List<String> currencyList) throws InterruptedException
	{		
		/*Create currency exchange code*/
		boolean update = currencyPage.enterCurrencyExchangeDetails(currencyList);

		if(update == true){
			currencyPage.clickOnUpdate();
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(1)+ " displayed in the list");
		}
	}

	private void verifyValues(CurrencyPage currencyPage,List<String> currencyList){
		currencyPage.searchValue(currencyList,2,1);
		
		/*Verify new currency record in the list*/
		if(currencyPage.verifyValues(currencyList.get(1)))
		
		{
			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(1)+ " displayed in the list");
		}
		else
		
		{
			testcases.add(getCurreentDate()+" | Fail : Currency "+currencyList.get(1)+ " not displayed in the list");
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
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A004" };
		String [] selectedNames = {"userName","passWord","code","gbpusdCurrency","gbpfrfCurrency","gbpdemCurrency","gbpeurCurrency","eurgbpCurrency","demgbpCurrency","frfgbpCurrency"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
