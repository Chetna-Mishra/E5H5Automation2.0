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
 * @author              :   Chetna Mishra
 * Test Reference No	: 	A004A Rate Types for Currency Exchange
 * Purpose              :   Set Up Rate Types Based On the Company
 * Date					:   18-01-2017
 * ACCESS               :   AGE
 */

public class A004A_Rate_Type_Currency_ExchangeTest extends BaseTest
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
		List<String> RateType = dataRow.findNamesReturnValues("RateType");
				
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify Rate Type search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Rate Type List","Rate Type search page","displayed");
		
		currencyPage.clickOnInsert();
		
		/*Create Rate Type*/
		createRateType(currencyPage,RateType);
						
		/*Exit from the currency exchange details page*/
		currencyPage.clickOnCancel();
		
		/*Verify Rate Type*/
		
		verifyValues(currencyPage,RateType);
		
		/*Logout from the application*/
		currencyPage.logOut(2);
	
	}
	
	private void createRateType(CurrencyPage currencyPage,List<String> currencyList) throws InterruptedException{		
		/*Create currency exchange code*/
		boolean update = currencyPage.enterRateTypeDetails(currencyList);	

		if(update == true){
			currencyPage.clickOnUpdate();
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(1)+ " displayed in the list");
		}
	}

	private void verifyValues(CurrencyPage currencyPage,List<String> currencyList){
		currencyPage.searchValue(currencyList,1,0);
		
		/*Verify new currency record in the list*/
		if(currencyPage.verifyValues(currencyList.get(1))){
			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(1)+ " displayed in the list");
		}
		else{
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
		String[] nodeID = { "A004A" };
		String [] selectedNames = {"userName","passWord","code","RateType"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
