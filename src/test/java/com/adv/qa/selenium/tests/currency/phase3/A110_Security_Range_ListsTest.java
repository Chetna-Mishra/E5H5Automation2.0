package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani/Chetna
 * Test Reference No	: 	A110 Security Range Lists 
 * Purpose              :   Security range Lists
 * Date					:   Modified on 16-May-2017
 * ACCESS               :   ADH, ADI
 */

public class A110_Security_Range_ListsTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> securitRangeForItemIM = dataRow.findNamesReturnValues("securitRangeForItemIM");
		List<String> securitRangeForStore = dataRow.findNamesReturnValues("securitRangeForStore");
		List<String> securitRangeForItem1PM = dataRow.findNamesReturnValues("securitRangeForItem1PM");
		List<String> securitRangeForItem1P = dataRow.findNamesReturnValues("securitRangeForItem1P");
		List<String> securitRangeForItem1IM = dataRow.findNamesReturnValues("securitRangeForItem1IM");

		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
	
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		createIMAccounts(currencyPage,securitRangeForItemIM,currencyCode);
		createIMAccounts(currencyPage,securitRangeForStore,currencyCode);
		createIMAccounts(currencyPage,securitRangeForItem1PM,currencyCode);
		createIMAccounts(currencyPage,securitRangeForItem1P,currencyCode);
		createIMAccounts(currencyPage,securitRangeForItem1IM,currencyCode);
	
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		verifyValues(currencyPage,securitRangeForItemIM);
		verifyValues(currencyPage,securitRangeForStore);
		verifyValues(currencyPage,securitRangeForItem1PM);
		verifyValues(currencyPage,securitRangeForItem1P);
		verifyValues(currencyPage,securitRangeForItem1IM);
		
		currencyPage.logOut(2);
	} 
	
	private void createIMAccounts(CurrencyPageNew currencyPage,List<String> elements,List<String> currencyCode) throws InterruptedException{

		String code = "EDTADRCDE ACT=INSERT,COMPANY="+companyId; 
		
		currencyPage.isCommandDisplayed();
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(code);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Range List Code Edit","Currency search page","displayed");
				
		/*Create security range*/
		currencyPage.insertSecurityRange(elements);	
		
		currencyPage.clickOnUpdate();	
		
		currencyPage.isCommandDisplayed();
	}	
	
private void verifyValues(CurrencyPageNew currencyPage,List<String> elements) throws InterruptedException{
		
		currencyPage.searchsecurityrange(companyId,elements);
	
		/*Verify new standard text in the list*/
		if(currencyPage.verifyValues(elements.get(0))){
			testcases.add(getCurreentDate()+" | Pass : New Store "+elements.get(0)+ " displayed in the list");
		}
		else{
			testcases.add(getCurreentDate()+" | Fail : New Store "+elements.get(0)+ " not displayed in the list");
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
		String xmlFilePath = folder  + "phase3.xml";
		String[] nodeID = { "A110" };
		String [] selectedNames = {"userName","passWord","currencyCode","securitRangeForItemIM","securitRangeForStore","securitRangeForItem1PM","securitRangeForItem1P","securitRangeForItem1IM"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
