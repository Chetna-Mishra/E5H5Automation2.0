package com.adv.qa.selenium.tests.currency.phase2;

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
 * Test Reference No	: 	A064 PPV Control Account
 * Purpose              :   Set Up Initial Batch Types
 * Date					:   19-06-2014/Modified on 24-Apr-2017 (Chetna)
 * ACCESS               :   PXM
 */

public class A064_PPV_Control_AccountTest extends BaseTest{
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
		List<String> ppvAccount = dataRow.findNamesReturnValues("ppvAccount");
				
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - PPV Control Account Codes List","Currency search page","displayed");
			
		currencyPage.searchValue(companyId,ppvAccount,2,1);
		
		currencyPage.clickOnInsert();
		
		/*Create batch type code*/
		currencyPage.enterPPVControlAccount(companyId,ppvAccount);	
	
		
		currencyPage.clickOnUpdate();
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
		
		/*Exit from the batch details page*/
		currencyPage.clickOnCancel();

		/*Verify new batch type in the list*/
		Assert.assertTrue(testcases,currencyPage.verifyValues(ppvAccount.get(0)), "New PPV Control account  "+ppvAccount.get(0),"displayed in the list");
			
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
		String[] nodeID = { "A064" };
		String [] selectedNames = {"userName","passWord","currencyCode","ppvAccount"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
