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
 * Test Reference No	: 	A003 Currency Base/Non Base Relationships
 * Purpose              :   Set Up Currency Relationships
 * Date					:   24-04-2014
 * ACCESS               :   AGC
 */

public class A003_Currency_Base_NonBase_RelationshipsTest extends BaseTest{	
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
		
		List<String> gbpfrfCurrency = dataRow.findNamesReturnValues("gbpfrfCurrency");
		List<String> gbpeurCurrency = dataRow.findNamesReturnValues("gbpeurCurrency");
		List<String> gbpdemCurrency = dataRow.findNamesReturnValues("gbpdemCurrency");
		List<String> gbpusdCurrency = dataRow.findNamesReturnValues("gbpusdCurrency");
		List<String> eurgbpCurrency = dataRow.findNamesReturnValues("eurgbpCurrency");
		List<String> frfgbpCuurency = dataRow.findNamesReturnValues("frfgbpCuurency");
		List<String> usdgbpCurrency = dataRow.findNamesReturnValues("usdgbpCurrency");
		List<String> demgbpCurrency = dataRow.findNamesReturnValues("demgbpCurrency");
	
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Currency Relationship List","Currency search page", "displayed");
		
		currencyPage.clickOnInsert();
				
		/*Create Base and Non Base currency*/
		createBaseNonBaseRelation(currencyPage,gbpfrfCurrency);
		createBaseNonBaseRelation(currencyPage,gbpeurCurrency);
		createBaseNonBaseRelation(currencyPage,gbpdemCurrency);
		createBaseNonBaseRelation(currencyPage,gbpusdCurrency);
		createBaseNonBaseRelation(currencyPage,eurgbpCurrency);
		createBaseNonBaseRelation(currencyPage,frfgbpCuurency);
		createBaseNonBaseRelation(currencyPage,usdgbpCurrency);
		createBaseNonBaseRelation(currencyPage,demgbpCurrency);
			
		
		/*Exit from the currency edit page*/
		currencyPage.clickOnCancel();
		
		verifyValues(currencyPage,gbpfrfCurrency);
		verifyValues(currencyPage,gbpeurCurrency);
		verifyValues(currencyPage,gbpdemCurrency);
		verifyValues(currencyPage,gbpusdCurrency);
		verifyValues(currencyPage,eurgbpCurrency);
		verifyValues(currencyPage,frfgbpCuurency);
		verifyValues(currencyPage,usdgbpCurrency);
		verifyValues(currencyPage,demgbpCurrency);
		
		
		/*Logout from the application*/
		currencyPage.logOut(2);

	}
	
	private void createBaseNonBaseRelation(CurrencyPage currencyPage,List<String> currencyList) throws InterruptedException{
		/*Create new currency code*/
		boolean update = currencyPage.enterCurrencyRelationshipDetails(currencyList);	
		
		if(update == true){
			currencyPage.clickOnUpdate();		
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(1)+ " displayed in the list");
		}
	}

	private void verifyValues(CurrencyPage currencyPage,List<String> currencyList){
		/*Search currency already present in the list*/
		currencyPage.searchValue(currencyList,2,1);

		/*Verify new currency in the list*/
		if(currencyPage.verifyValues(currencyList.get(1))){
			testcases.add(getCurreentDate()+" | Pass : Currency "+currencyList.get(1) +" "+currencyList.get(2)+ " displayed in the list");
		}
		else{
			testcases.add(getCurreentDate()+" | Fail : Currency "+currencyList.get(1) +" "+currencyList.get(2)+  " not displayed in the list");
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
		String[] nodeID = { "A003" };
		String [] selectedNames = {"userName","passWord","code","gbpfrfCurrency","gbpeurCurrency","gbpdemCurrency","gbpusdCurrency","eurgbpCurrency","frfgbpCuurency","usdgbpCurrency","demgbpCurrency"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
